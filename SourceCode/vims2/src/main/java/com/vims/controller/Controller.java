package com.vims.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vims.generators.PolicyIdGenerator;
import com.vims.model.AccidentClaim;
import com.vims.model.AdminLogin;
import com.vims.model.Cancellation;
import com.vims.model.Customer;
import com.vims.model.DirectPay;
import com.vims.model.RegisteredPay;
import com.vims.model.TheftClaim;
import com.vims.model.VehicleRegistration;
import com.vims.service.AccidentClaimService;
import com.vims.service.CancellationService;
//import com.vims.service.CancellationService;
import com.vims.service.CustomerService;
import com.vims.service.DirectPayService;
import com.vims.service.RegisteredPayService;
import com.vims.service.TheftClaimService;
import com.vims.service.VehicleService;

@RestController
@CrossOrigin
@ComponentScans(value = { @ComponentScan("com.vims.dao"), @ComponentScan("com.vims.service") })
@RequestMapping(value = "/vims")
public class Controller {

	//===========================================Admin=================================//
	@PostMapping(value = "/admin/login")
	public ResponseEntity<?> loginAdmin(@RequestBody AdminLogin c) {
		
		//String cid=custService.findByCustomer(username, password);
		
		if(c.getUsername().equals("admin")&&c.getPassword().equals("admin")) {
			return new ResponseEntity<String>("login successful", HttpStatus.OK);

		}
		return new ResponseEntity<String>("Customer not found", HttpStatus.OK);
	}
	
	// ========================================== Customer Controller ===========================================================
	
	@Autowired
	private CustomerService custService;
	List<Customer> customers = null;
	Optional<Customer> customer=null;
	List<VehicleRegistration>policies=null;
	@PostMapping(value = "/customer/login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer c) {
		
		String cid=custService.findByCustomer(c.getUsername(), c.getPassword());
		
		if(cid==null) {
			return new ResponseEntity<String>("Customer not found", HttpStatus.OK);

		}
		return new ResponseEntity<String>("login successful", HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/customer")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
		
		String user=customer.getUsername();
		String pass=customer.getPassword();
		String cid=custService.findByCustomer(user, pass);
		if(cid!=null) {
			return new ResponseEntity<String>("Customer already exists enter different username and password", HttpStatus.OK);
		}
		customer=custService.save(customer);
		
		if(customer==null) {
			return new ResponseEntity<String>("Customer not saved", HttpStatus.OK);

		}
		return new ResponseEntity<String>(customer.getCustomer_id()+" is saved successfully", HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/customer/findall")
	public ResponseEntity<?> listAll() {
		customers = custService.findAll();
		if (customers.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@PostMapping("/customer/find")
	public ResponseEntity<?> findById(@RequestBody Customer c) throws Exception {
		
		
		
		customer=custService.findById(c.getCustomer_id());
		
		if(!customer.isPresent()) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("customer Id  "+c.getCustomer_id()+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<Customer>> (customer,HttpStatus.OK);
	}
	
	@PostMapping(value = "/customer/findallpolicies")
	public ResponseEntity<?> listAllPoliciesOfCustomer(@RequestBody Customer customer) {
		policies=custService.getVehicleDetails(customer.getCustomer_id());
	
		if (policies.isEmpty()) {
			return new ResponseEntity<String>("No vehicle policies available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<VehicleRegistration>>(policies, HttpStatus.OK);
	}
	
	@PutMapping(value = "/customer/update")
	public ResponseEntity<?> updateProduct(@RequestBody Customer customer) {
		customer=custService.save(customer);
		
		if(customer==null) {
			return new ResponseEntity<String>("customer not updated", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>(customer.getCustomer_id()+" is updated", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/customer/delete")
	public ResponseEntity<?> deleteProduct(@RequestBody Customer customer) {
		custService.deleteById(customer.getCustomer_id());
		
		return  new ResponseEntity<String>("Product Id with "+customer.getCustomer_id()+" Deleteted", HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExceptin(Exception e) {
		return new ResponseEntity<String>("Provided URL not valid. make sure its should be /customers/ "+e,HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/error")
	public ResponseEntity<String> handleExceptin1() {
		return new ResponseEntity<String>("Provided URL not valid. make sure its should be /customers/ ",HttpStatus.NOT_FOUND);
	}
	
	
	
	// ==========================================================================================================================
	
	// ======================================vehicle registration===============================//
	
	@Autowired
	private VehicleService vehicleService;
	List<VehicleRegistration> vehicles = null;
	//Optional<VehicleRegistration> vehicle=null;
	
	@PostMapping(value = "/vehicle/save")
	public ResponseEntity<?> saveVehicle(@RequestBody VehicleRegistration vehicle) {
		System.out.println("vehicle savvee");
		Calendar cal=Calendar.getInstance();cal.setTime(vehicle.getDate_of_purchase());
		cal.add(Calendar.YEAR, 1);
		vehicle.setMaturity_date(cal.getTime());
		if(vehicle.getVehicle_type().equalsIgnoreCase("TW")){
			 PolicyIdGenerator.key="TW";
			}
		if(vehicle.getVehicle_type().equalsIgnoreCase("FW")){
			PolicyIdGenerator.key="FW";
			}
		
		if(vehicle.getVehicle_class().equalsIgnoreCase("own")){
	        vehicle.setPremium_amount(Double.toString((Double.parseDouble(vehicle.getPrice())*(0.065))/12));
	        
	        }else{
	        	 vehicle.setPremium_amount(Double.toString((Double.parseDouble(vehicle.getPrice())*(0.065)+(Double.parseDouble(vehicle.getPrice()))/12)));
	        	 
	        }
		Date d=new Date();
		Calendar cal1=Calendar.getInstance();
		cal1.setTime(d);
		cal1.add(Calendar.YEAR, 1);
		vehicle.setMaturity_date(cal1.getTime());
		vehicle=vehicleService.save(vehicle);
		if(vehicle==null) {
			System.out.println("returned");
			return new ResponseEntity<String>("vehicle not saved", HttpStatus.OK);
		

		}
		System.out.println("returned");
		return new ResponseEntity<String>("vehicle with policy id: "+vehicle.getPolicy_id()+" is saved with customer id: "+vehicle.getCustomer_id()+" premium amount is: "+vehicle.getPremium_amount()+" Maturity date is: "+vehicle.getMaturity_date(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/vehicle/findall")
	public ResponseEntity<?> listAllVehicles() {
		vehicles = vehicleService.findAll();
		if (vehicles.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<VehicleRegistration>>(vehicles, HttpStatus.OK);
	}
	
	@GetMapping("/vehicle/findvehiclesbycustomerid/{customer_id}")
	public ResponseEntity<?> findVehiclesByCustomerId(@PathVariable String customer_id) throws Exception {
		
		
		List<VehicleRegistration>vehicles=custService.getVehicleDetails(customer_id);
		
		if(vehicles==null) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("custId not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<List<VehicleRegistration>> (vehicles,HttpStatus.OK);
	}

	@PostMapping("/vehicle/findusingpolicyid")
	public ResponseEntity<?> findVehicleById(@RequestBody VehicleRegistration vehicle) throws Exception {
		
		if(vehicle.getCustomer_id().equals("P001"))
		throw new Exception();
		
		vehicle=vehicleService.findById(vehicle.getPolicy_id()).get();
		
		if(vehicle==null) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("policyd  Id  "+vehicle.getPolicy_id()+" not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<VehicleRegistration> (vehicle,HttpStatus.OK);
	}
	
	@PutMapping(value = "/vehicle/update/")
	public ResponseEntity<?> updateVehicle(@RequestBody VehicleRegistration vehicle) {
		vehicle=vehicleService.save(vehicle);
		
		if(vehicle==null) {
			return new ResponseEntity<String>("vehicle not saved", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>(vehicle.getPolicy_id()+" is updated", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/vehicle/delete")
	public ResponseEntity<?> deleteVehicle(@RequestBody VehicleRegistration vehicle) {
		vehicleService.deleteById(vehicle.getPolicy_id());
		
		return  new ResponseEntity<String>("vehicle  with "+vehicle.getPolicy_id()+" Deleteted", HttpStatus.OK);
	}
	
	
	//========================direct pay============
	@Autowired
	private DirectPayService directPayService;
	List<DirectPay> directpays = null;
	Optional<DirectPay> directpay=null;
	
	@PostMapping(value = "/directpay/save")
	public ResponseEntity<?> saveDirectPay(@RequestBody DirectPay pay) {
		VehicleRegistration v=vehicleService.findById(pay.getPolicy_id()).get();
		//pay.setVehicle(v);
		System.out.println("line1");
		List<DirectPay> l1=vehicleService.getDirectPayDetails(pay.getPolicy_id());
		List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(pay.getPolicy_id());
		Date max=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(max);
		c.set(2000, 01, 01);
		max=c.getTime();
		Date d=new Date();
		System.out.println("line2");
		if(l1.size()==0&&l2.size()==0){
			
			pay.setPayment_date(d);
			Date payment_date=pay.getPayment_date();
			max=payment_date;
			
		}else {
				if(l1.size()==0&&l2.size()!=0){
					max=l2.get(0).getDue_date();
					for(RegisteredPay l:l2) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
				}
				}
				else if(l2.size()==0&&l1.size()!=0){
					max=l1.get(0).getDue_date();
					for(DirectPay l:l1) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
					}
				}else{
					for(DirectPay l:l1) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
					}
					
					for(RegisteredPay l:l2) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
				}
		}
		}
		System.out.println("line3");
		pay.setPayment_date(d);
		Calendar cal=Calendar.getInstance();
		cal.setTime(max);
		
		if(max.before(d)){
			return new ResponseEntity<String>("you cannot pay using direct pay as due date is over. Please proceed to Registered Pay.", HttpStatus.OK);
		}
		//cal.setTime(max);
		cal.add(Calendar.MONTH, 1);
		pay.setDue_date(cal.getTime());
		String pa=v.getPremium_amount();
		double fap=0;System.out.println("line4");
		 if(pay.getPay_mode().equalsIgnoreCase("credit card")){
		        fap=Double.parseDouble(pa)*0.023+Double.parseDouble(pa);
		        }
		        else{
		        	 fap=Double.parseDouble(pa);
		        }
		       // double fap1=String.valueOf(fap);
		 
		        pay.setAmount_paid(fap);
		        pay.setPremium_amount(v.getPremium_amount());
		pay=directPayService.save(pay);
		
		if(pay==null) {
			return new ResponseEntity<String>("directpay not saved", HttpStatus.OK);

		}
		return new ResponseEntity<String>("payment processed successfully and payment id is: "+pay.getPayment_id()+" next payment date is: "+pay.getDue_date()+" max date is"+max, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/directpay/findall")
	public ResponseEntity<?> listAllDirectPay() {
		directpays = directPayService.findAll();
		if (directpays.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<DirectPay>>(directpays, HttpStatus.OK);
	}
	
	@GetMapping(value = "/directpay/findallpay/{policy_id}")
	public ResponseEntity<?> listAllDirectPayByVehicle(@PathVariable String policy_id) {
		List<DirectPay>l1=vehicleService.getDirectPayDetails(policy_id);
		
		if (l1.size()==0) {
			return new ResponseEntity<String>("No registered payments available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<DirectPay>>(l1, HttpStatus.OK);
	}
	
	@PostMapping("/directpay/finddirectpaybyid")
	public ResponseEntity<?> findDirectPayById(@RequestBody DirectPay pay) throws Exception {
		
		
		
		directpay=directPayService.findById(pay.getPayment_id());
		
		if(!directpay.isPresent()) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("payment_id    "+pay.getPayment_id()+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<DirectPay>> (directpay,HttpStatus.OK);
	}
	
	@PutMapping(value = "/directpay/update/")
	public ResponseEntity<?> updateDirectPay(@RequestBody DirectPay directpay) {
		directpay=directPayService.save(directpay);
		
		if(directpay==null) {
			return new ResponseEntity<String>("directpay not saved", HttpStatus.OK);

		}
		
		return new ResponseEntity<DirectPay>(directpay, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/directpay/delete/{payment_id}")
	public ResponseEntity<?> deleteDirectPay(@RequestBody DirectPay pay) {
		directPayService.deleteById(pay.getPayment_id());
		
		return  new ResponseEntity<String>("directpay Id with "+pay.getPayment_id()+" Deleteted", HttpStatus.OK);
	}
	
	//=============================registered pay=========================//
	@Autowired
	private RegisteredPayService registeredPayService;
	List<RegisteredPay> registeredpays = null;
	Optional<RegisteredPay> registeredpay=null;
	
	@PostMapping(value = "/registeredpay")
	public ResponseEntity<?> saveRegisteredPay(@RequestBody RegisteredPay pay) {
		VehicleRegistration v=vehicleService.findById(pay.getPolicy_id()).get();
		//RegisteredPay pay=new RegisteredPay();
		
		pay.setPremium_amount(v.getPremium_amount());
		List<DirectPay> l1=vehicleService.getDirectPayDetails(pay.getPolicy_id());
		List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(pay.getPolicy_id());
		Date max=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(max);
		c.set(2000, 01, 01);
		max=c.getTime();
		System.out.println("line1");
		Date d=new Date();
		if(l1.size()==0&&l2.size()==0){
			pay.setPaid_date(d);
			Date payment_date=pay.getPaid_date();
			max=payment_date;
			
		}else {
				if(l1.size()==0){
					max=l2.get(0).getDue_date();
					for(RegisteredPay l:l2) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
				}
				}
				else if(l2.size()==0){
					max=l1.get(0).getDue_date();
					for(DirectPay l:l1) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
					}
				}else{
					
					for(DirectPay l:l1) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
					}
					
					for(RegisteredPay l:l2) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
				}
		}
		}
		System.out.println("line2");
		Calendar cal1=Calendar.getInstance();
		pay.setDue_date(max);
		cal1.setTime(max);
		if(max.after(d)){
			return new ResponseEntity<String>("registered pay cannot be done as due date is not over", HttpStatus.OK);
		}
		cal1.setTime(pay.getPaid_date());
		cal1.add(Calendar.MONTH, 1);
		pay.setPaid_date(d);
		
		String pa=v.getPremium_amount();
		 double fap=0;
    	 Date d1=max;
    	 
    		        Date d2=pay.getPaid_date();
    		        System.out.println("line5");
    		        Calendar cal=Calendar.getInstance();
    		        cal.setTime(d1); 
    		        System.out.println("line6");
    		        double g1=cal.getTimeInMillis();
    		        
    		        cal.setTime(d2);
    		        System.out.println("line7");
    		        double g2=cal.getTimeInMillis();
    		        System.out.println("line3");
    		        double diff=(g2-g1)/(60*60*24*1000);
    		        int months=(int) (diff/28);
    		        
    		        System.out.println("line4");
    		        if(pay.getPayment_mode().equalsIgnoreCase("credit card")){
    		        	
    		      fap=Double.parseDouble(pa)+(Double.parseDouble(pa)*months)+Double.parseDouble(pa)*diff*(0.0056)+((Double.parseDouble(pa)*months)+Double.parseDouble(pa)*diff*(0.0056))*0.023;
    		       
    		        
    		        }
    		        
    		        else{
    		        	
    		        	 fap=Double.parseDouble(pa)+(Double.parseDouble(pa)*months)+Double.parseDouble(pa)*diff*(0.0056);
    		        }
    		        String fap1=String.valueOf(fap);
    		        
    	 pay.setPay_amount(fap1);
    	 pay.setDue_date(cal1.getTime());
    	
    	 pay=registeredPayService.save(pay);
		
		if(pay==null) {
			return new ResponseEntity<String>("registeredpay not saved", HttpStatus.OK);

		}
		return new ResponseEntity<String>("payment processed successfully with payment id: "+pay.getPayment_id()+" and next payment date is: "+pay.getDue_date()+" total amount paid is: "+fap1, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registeredpay/lastpaid")
	public ResponseEntity<?> LastPaidRegisteredPay(@RequestBody RegisteredPay pay1) {
		
		List<DirectPay> l1=vehicleService.getDirectPayDetails(pay1.getPolicy_id());
		List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(pay1.getPolicy_id());
		Date max=new Date();System.out.println("line1");
		Calendar c=Calendar.getInstance();
		c.setTime(max);
		c.set(2000, 01, 01);
		max=c.getTime();
		
		RegisteredPay pay=new RegisteredPay();
		Date d=new Date();
		pay.setPaid_date(d);
		System.out.println("line2");
				if(l1.size()==0){
					max=l2.get(0).getDue_date();
					for(RegisteredPay l:l2) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
							pay=l;
						}
				}
				}
				else if(l2.size()==0){
					max=l1.get(0).getDue_date();
					for(DirectPay l:l1) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
					}
				}else{
					for(DirectPay l:l1) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
					}
					
					for(RegisteredPay l:l2) {
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();pay=l;
							
						}
				}
		}
		System.out.println("line3");
				VehicleRegistration v=vehicleService.findById(pay1.getPolicy_id()).get();
				
		
		pay.setDue_date(max);
		if(max.after(d)){
			return new ResponseEntity<String>("Your due date is not yet over. Please proceed to Direct Pay ", HttpStatus.OK);
		}
		
		System.out.println("line4");
		
		String pa=v.getPremium_amount();
		 double fap=0;
    	 Date d1=pay.getDue_date();
    		        Date d2=pay.getPaid_date();
    		        Calendar cal=Calendar.getInstance();
    		        cal.setTime(d1);long g1=cal.getTimeInMillis();
    		        cal.setTime(d2);long g2=cal.getTimeInMillis();
    		        long diff=(g2-g1)/(60*60*24*1000); 
    		        int months=(int) (diff/28);
    		        
    		        fap=Double.parseDouble(pa)+(Double.parseDouble(pa)*months)+Double.parseDouble(pa)*diff*(0.0056);
    		        
    		        String fap1=String.valueOf(fap);
    	 pay.setPay_amount(fap1);
		System.out.println("line5");
		if(pay==null) {
			System.out.println("line6");
			return new ResponseEntity<String>("registered pay does not exist", HttpStatus.OK);

		}
		System.out.println("line7");
		return new ResponseEntity<String>("Your due date is over on : "+pay.getDue_date()+" and amount to be paid with fine is :"+pay.getPay_amount(), HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/registeredpay/findall")
	public ResponseEntity<?> listAllRegisteredPay() {
		registeredpays = registeredPayService.findAll();
		if (registeredpays.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<RegisteredPay>>(registeredpays, HttpStatus.OK);
	}
	
	@GetMapping(value = "/registeredpay/findallpay/{policy_id}")
	public ResponseEntity<?> listAllRegisteredPayByVehicle(@PathVariable String policy_id) {
		List<RegisteredPay>l1=vehicleService.getRegisteredPayDetails(policy_id);
		
		if (l1.size()==0) {
			return new ResponseEntity<String>("No registered payments available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<RegisteredPay>>(l1, HttpStatus.OK);
	}
	
	@PostMapping("/registeredpay/find")
	public ResponseEntity<?> findRegisteredPayById(@RequestBody RegisteredPay pay) throws Exception {
		
		if(pay.getPayment_id().equals("P001"))
		throw new Exception();
		
		registeredpay=registeredPayService.findById(pay.getPayment_id());
		
		if(!registeredpay.isPresent()) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("payment_id    "+pay.getPayment_id()+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<RegisteredPay>> (registeredpay,HttpStatus.OK);
	}
	
	@PutMapping(value = "/registeredpay/update/")
	public ResponseEntity<?> updateRegisteredPay(@RequestBody RegisteredPay registeredpay) {
		registeredpay=registeredPayService.save(registeredpay);
		
		if(registeredpay==null) {
			return new ResponseEntity<String>("registeredpay not saved", HttpStatus.OK);

		}
		
		return new ResponseEntity<RegisteredPay>(registeredpay, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/registeredpay/delete")
	public ResponseEntity<?> deleteRegisteredPay(@RequestBody RegisteredPay pay) {
		registeredPayService.deleteById(pay.getPayment_id());
		
		return  new ResponseEntity<String>("registeredpay Id with "+pay.getPayment_id()+" Deleteted", HttpStatus.OK);
	}
	
	
	//==================================accident claim=============================//
	@Autowired
	private AccidentClaimService accidentclaimservice;
	List<AccidentClaim> accidentclaims = null;
	Optional<AccidentClaim> accidentclaim=null;
	
	@PostMapping(value = "/accidentclaim/save")
	public ResponseEntity<?> saveAccidentClaim(@RequestBody AccidentClaim accidentclaim) {
		System.out.println("line1");
		//Customer c=custService.findById(accidentclaim.getCustomer_id()).get();
		VehicleRegistration v=vehicleService.findById(accidentclaim.getPolicy_id()).get();
		
		String type=accidentclaim.getAccident_type();
		System.out.println(type);
		if(v.getVehicle_type().equals("TW")) {

        if(type.equalsIgnoreCase("fire")){
        	accidentclaim.setWeightage("80");
        }else if(type.equalsIgnoreCase("road accident")){
        	accidentclaim.setWeightage("70");
        }
        else if(type.equalsIgnoreCase("malicious acts")){
        	accidentclaim.setWeightage("50");
        }else if(type.equalsIgnoreCase("self-destruction")){
        	accidentclaim.setWeightage("40");
        }else if(type.equalsIgnoreCase("part failure")){
        	accidentclaim.setWeightage("20");
        }
		}
		if(v.getVehicle_type()=="FW") {
			 if(type.equalsIgnoreCase("fire")){
		        	accidentclaim.setWeightage("70");
		        }else if(type.equalsIgnoreCase("road accident")){
		        	accidentclaim.setWeightage("65");
		        }
		        else if(type.equalsIgnoreCase("malicious acts")){
		        	accidentclaim.setWeightage("50");
		        }else if(type.equalsIgnoreCase("self-destruction")){
		        	accidentclaim.setWeightage("30");
		        }else if(type.equalsIgnoreCase("part failure")){
		        	accidentclaim.setWeightage("20");
		        }
		}
		
        List<AccidentClaim>aclaims=vehicleService.getAccidentClaimDetails(accidentclaim.getPolicy_id());
        List<TheftClaim>tclaims=vehicleService.getTheftClaimDetails(accidentclaim.getPolicy_id());
        if(aclaims.size()>0||tclaims.size()>0) {
        	return new ResponseEntity<String>("not eligible for claim as you have already claimed", HttpStatus.OK);
        }
        System.out.println("line2");
        //double totalamount=Double.parseDouble(accidentclaim.getTotal_amount());
        double claimamount=0;
        double vehicleprice=Double.parseDouble(v.getPrice());
        Date purchase_date=v.getDate_of_purchase();
        Date d=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(purchase_date);
        System.out.println("line3");
        cal.add(Calendar.YEAR, 5);double maxamount=0;
        if(cal.before(d)){
        	maxamount=vehicleprice/2;
        	if(maxamount<claimamount){
        		return new ResponseEntity<String>("not eligible for claim as vehicle is purchased before 5years and max claim amount is half of vehicle price", HttpStatus.OK);
        	}
        }else{
        	maxamount=vehicleprice*1.02;
        	if(maxamount<claimamount){
        		return new ResponseEntity<String>("not eligible for claim as max claim amount is 2% more than vehicle price", HttpStatus.OK);
        	}
        }System.out.println("line4");System.out.println(accidentclaim.getTotal_amount());
		 System.out.println(accidentclaim.getWeightage());
		 System.out.println(v.getVehicle_type());
		 claimamount=Double.parseDouble(accidentclaim.getTotal_amount())*Double.parseDouble(accidentclaim.getWeightage())/100;
		 //
		 
		if(claimamount<5000&&v.getVehicle_type()=="TW") {
			return new ResponseEntity<String>("not eligible for claim as claim amount is less than 5000", HttpStatus.OK);
		}
		else if(claimamount<20000&&v.getVehicle_type()=="FW") {
			return new ResponseEntity<String>("not eligible for claim as claim amount is less than 20000", HttpStatus.OK);
		}
		accidentclaim.setClaim_amount(Double.toString(claimamount));
		accidentclaim.setStatus("Processing");
		System.out.println("line5");
		accidentclaim=accidentclaimservice.save(accidentclaim);
		
		if(accidentclaim==null) {
			return new ResponseEntity<String>("accidentclaim not saved", HttpStatus.OK);

		}
		return new ResponseEntity<String>("claimed processed sucessfully and claim id is :"+accidentclaim.getClaim_id()+" and claimed amount is:"+accidentclaim.getClaim_amount(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/findtotalamount")
	public ResponseEntity<?> totalAmountPaidByUser(@RequestBody AccidentClaim accidentclaim){
		
		List<DirectPay> l1=vehicleService.getDirectPayDetails(accidentclaim.getPolicy_id());
		List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(accidentclaim.getPolicy_id());
		double directamount=0;Date max=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(max);
		c.set(2000, 01, 01);
		max=c.getTime();
		if(l1.size()==0){
			max=l2.get(0).getDue_date();
			for(RegisteredPay l:l2) {
				directamount+=Double.parseDouble(l.getPay_amount());
				if(l.getDue_date().after(max)) {
					max=l.getDue_date();
				}
		}
		}
		else if(l2.size()==0){
			max=l1.get(0).getDue_date();
			for(DirectPay l:l1) {
				directamount+=(l.getAmount_paid());
				if(l.getDue_date().after(max)) {
					max=l.getDue_date();
				}
			}
		}else{
			for(DirectPay l:l1) {
				directamount+=(l.getAmount_paid());
				if(l.getDue_date().after(max)) {
					max=l.getDue_date();
				}
			}
			
			for(RegisteredPay l:l2) {
				directamount+=Double.parseDouble(l.getPay_amount());
				if(l.getDue_date().after(max)) {
					max=l.getDue_date();
				}
		}
}
		return new ResponseEntity<String>("total amount paid is :"+directamount+"with policy id: "+accidentclaim.getPolicy_id(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/accidentclaim/findall")
	public ResponseEntity<?> listAllAccidentClaim() {
		accidentclaims = accidentclaimservice.findAll();
		if (accidentclaims.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<AccidentClaim>>(accidentclaims, HttpStatus.OK);
	}
	
	@GetMapping("/accidentclaim/findaccidentclaimsbycustid/{custId}")
	public ResponseEntity<?> findAccidentClaimsByCustomerId(@PathVariable String custId) throws Exception {
		
		
		
		List<AccidentClaim>aclaims=custService.getAccidentClaimDetails(custId);
		
		if(aclaims==null) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("claim_id   "+custId+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<List<AccidentClaim>> (aclaims,HttpStatus.OK);
	}
	
	@PutMapping(value = "/accidentclaim/update/")
	public ResponseEntity<?> updateAccidentClaim(@RequestBody AccidentClaim accidentclaim) {
		accidentclaim=accidentclaimservice.save(accidentclaim);
		
		if(accidentclaim==null) {
			return new ResponseEntity<String>("accidentclaim not saved", HttpStatus.OK);

		}
		
		return new ResponseEntity<AccidentClaim>(accidentclaim, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/accidentclaim/delete")
	public ResponseEntity<?> deleteAccidentClaim(@RequestBody AccidentClaim accidentclaim) {
		accidentclaimservice.deleteById(accidentclaim.getClaim_id());
		
		return  new ResponseEntity<String>("accidentclaim Id with "+accidentclaim.getClaim_id()+" Deleteted", HttpStatus.OK);
	}
	
	@GetMapping(value = "/accidentclaim/approve/{claim_id}")
	public ResponseEntity<?> approveAccidentClaim(@PathVariable String claim_id) {
		AccidentClaim tc=accidentclaimservice.findById(claim_id).get();
		tc.setStatus("approved");
		tc=accidentclaimservice.save(tc);
		if(tc==null) {
			return new ResponseEntity<String>("accidentclaim not found", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>("Approved successfully", HttpStatus.OK);
	}
	
	@GetMapping(value = "/accidentclaim/reject/{claim_id}")
	public ResponseEntity<?> rejectAccidentClaim(@PathVariable String claim_id) {
		AccidentClaim tc=accidentclaimservice.findById(claim_id).get();
		tc.setStatus("rejected");
		tc=accidentclaimservice.save(tc);
		if(tc==null) {
			return new ResponseEntity<String>("accidentclaim not found", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>("rejected successfully", HttpStatus.OK);
	}
	//========================theft claim=================//
	@Autowired
	private TheftClaimService theftclaimservice;
	List<TheftClaim> theftclaims = null;
	Optional<TheftClaim> theftclaim=null;
	
	@PostMapping(value = "/theftclaim/save")
	public ResponseEntity<?> saveTheftClaim(@RequestBody TheftClaim theftclaim) {
		Customer c=custService.findById(theftclaim.getCustomer_id()).get();
		VehicleRegistration v=vehicleService.findById(theftclaim.getPolicy_id()).get();
		
		double claimamount=((Double.parseDouble(theftclaim.getTotal_amount())*0.75));
		Date d1=theftclaim.getTheft_date();
        Date d2=theftclaim.getComplaint_date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(d1);long l1=cal.getTimeInMillis();
        cal.setTime(d2);long l2=cal.getTimeInMillis();
        long diff=(l2-l1)/(60*60*24*1000);
        List<AccidentClaim>aclaims=vehicleService.getAccidentClaimDetails(theftclaim.getPolicy_id());
        List<TheftClaim>tclaims=vehicleService.getTheftClaimDetails(theftclaim.getPolicy_id());
        if(aclaims.size()>0||tclaims.size()>0) {
        	return new ResponseEntity<String>("not eligible for claim as you have already claimed", HttpStatus.OK);
        }
        if(diff>10){
        	return new ResponseEntity<String>("not eligible for claim as you have filed complaint after 10days of theft", HttpStatus.OK);
        }
        
        Date d=new Date();
        Date purchase_date=v.getDate_of_purchase();
        Calendar cal1=Calendar.getInstance();
        cal1.setTime(purchase_date);
        
        double maxamount=0;
        double vehicleprice=Double.parseDouble(v.getPrice());
        cal1.add(Calendar.YEAR, 5);
        if(cal1.before(d)){
        	maxamount=vehicleprice/2;
        	if(maxamount<claimamount){
        		return new ResponseEntity<String>("not eligible for claim as vehicle is registered 5 years ago and maximum claim amount is half of vehicle price", HttpStatus.OK);
        	}
        }else{
        	
        	maxamount=vehicleprice*1.02;
        	if(maxamount<claimamount){
        		return new ResponseEntity<String>("not eligible for claim as max claimable amount is 2% greater than vehicle price", HttpStatus.OK);
        	}
        }
        theftclaim.setClaim_amount(Double.toString(claimamount));
        theftclaim.setStatus("Processing");
		theftclaim=theftclaimservice.save(theftclaim);
		
		if(theftclaim==null) {
			return new ResponseEntity<String>("theftclaim not saved", HttpStatus.OK);

		}
		return new ResponseEntity<String>("claimed processed successfully and claim id is: "+theftclaim.getClaim_id()+"claimed amount is :"+theftclaim.getClaim_amount(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/theftclaim/approve/{claim_id}")
	public ResponseEntity<?> approveTheftClaim(@PathVariable String claim_id) {
		
		System.out.println("enter");
		TheftClaim tc=theftclaimservice.findById(claim_id).get();
		tc.setStatus("approved");
		System.out.println(tc.getStatus());
		tc=theftclaimservice.save(tc);
		if(tc==null) {
			return new ResponseEntity<String>("theftclaim not found", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>("Approved successfully", HttpStatus.OK);
	}
	
	@GetMapping(value = "/theftclaim/reject/{claim_id}")
	public ResponseEntity<?> rejectTheftClaim(@PathVariable String claim_id) {
		TheftClaim tc=theftclaimservice.findById(claim_id).get();
		tc.setStatus("rejected");
		tc=theftclaimservice.save(tc);
		if(tc==null) {
			return new ResponseEntity<String>("theftclaim not found", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>("rejected successfully", HttpStatus.OK);
	}

	
	@GetMapping(value = "/theftclaim/findall")
	public ResponseEntity<?> listAllTheftClaim() {
		theftclaims = theftclaimservice.findAll();
		if (theftclaims.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<TheftClaim>>(theftclaims, HttpStatus.OK);
	}
	
	@PostMapping("/theftclaim/findtheftclaimbyid")
	public ResponseEntity<?> findTheftClaimById(@RequestBody TheftClaim theftclaim) throws Exception {
		
		if(theftclaim.getClaim_id().equals("P001"))
		throw new Exception();
		
		theftclaim=theftclaimservice.findById(theftclaim.getClaim_id()).get();
		
		if(theftclaim==null) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("claim_id  Id  "+theftclaim.getClaim_id()+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<TheftClaim> (theftclaim,HttpStatus.OK);
	}
	@GetMapping("/theftclaim/findtheftclaimsbycustid/{custId}")
	public ResponseEntity<?> findTheftClaimsByCustomerId(@PathVariable String custId) throws Exception {
		
		
		
		List<TheftClaim>aclaims=custService.getTheftClaimDetails(custId);
		
		if(aclaims==null) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("claim_id   "+custId+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<List<TheftClaim>> (aclaims,HttpStatus.OK);
	}
	
	@PutMapping(value = "/theftclaim/update/")
	public ResponseEntity<?> updateTheftClaim(@RequestBody TheftClaim theftclaim) {
		theftclaim=theftclaimservice.save(theftclaim);
		
		if(theftclaim==null) {
			return new ResponseEntity<String>("theftclaim not saved", HttpStatus.OK);

		}
		
		return new ResponseEntity<TheftClaim>(theftclaim, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/theftclaim/delete")
	public ResponseEntity<?> deleteTheftClaim(@RequestBody TheftClaim theftclaim) {
		theftclaimservice.deleteById(theftclaim.getClaim_id());
		
		return  new ResponseEntity<String>("theftclaim Id with "+theftclaim.getClaim_id()+" Deleteted", HttpStatus.OK);
	}
	
	//==============================cancellation======================//
	@Autowired
	private CancellationService cancelservice;
	List<Cancellation> cancels = null;
	Optional<Cancellation> cancel=null;
	
	@PostMapping(value = "/cancel/save")
	public ResponseEntity<String> saveCancellation(@RequestBody Cancellation can1) {
		VehicleRegistration v=vehicleService.findById(can1.getPolicy_id()).get();
		Cancellation can=new Cancellation();
		
		//can.setRegistered_date(v.getDate_of_purchase());
		//can.setTotal_amount(Double.toString(directPayService.findTotalAmountByCustomerId(custId)));

	    Date s2=new Date();
	    Date s1=null;
	    
	    List<DirectPay> l1=vehicleService.getDirectPayDetails(can1.getPolicy_id());
		List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(can1.getPolicy_id());
		Date max=new Date();
		Calendar c1=Calendar.getInstance();
		c1.setTime(max);
		c1.set(2000, 01, 01);
		max=c1.getTime();
		Date lastpaiddate=c1.getTime();
		//System.out.println("line1");
		double directamount=0;
				if(l1.size()==0){
					max=l2.get(0).getDue_date();
					for(RegisteredPay l:l2) {directamount+=Double.parseDouble(l.getPay_amount());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPaid_date())){
							lastpaiddate=l.getPaid_date();
						}
				}
				}
				else if(l2.size()==0){
					max=l1.get(0).getDue_date();
					for(DirectPay l:l1) {directamount+=(l.getAmount_paid());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPayment_date())){
							lastpaiddate=l.getPayment_date();
						}
					}
				}else{
					for(DirectPay l:l1) {directamount+=(l.getAmount_paid());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPayment_date())){
							lastpaiddate=l.getPayment_date();
						}
					}
					
					for(RegisteredPay l:l2) {directamount+=Double.parseDouble(l.getPay_amount());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPaid_date())){
							lastpaiddate=l.getPaid_date();
						}
				}
		}

//
				
				//System.out.println("line2");
	       s1=max;
	       can.setLast_paid_date(lastpaiddate);
	       Date s3=null;Date min=new Date();
	       can.setCancel_date(s2);
	       
	       can.setLast_paid_date(lastpaiddate);
	       can.setTotal_amount(Double.toString(directamount));
	       if(l1.size()==0){
				min=l2.get(0).getDue_date();
				for(RegisteredPay l:l2) {
					if(l.getPaid_date().before(min)) {
						min=l.getPaid_date();
					}
			}
			}
			else if(l2.size()==0){
				min=l1.get(0).getDue_date();
				for(DirectPay l:l1) {
					if(l.getPayment_date().before(min)) {
						min=l.getPayment_date();
					}
				}
			}else{
				for(DirectPay l:l1) {
					if(l.getPayment_date().before(min)) {
						min=l.getPayment_date();
					}
				}
				
				for(RegisteredPay l:l2) {
					if(l.getPaid_date().before(min)) {
						min=l.getPaid_date();
					}
			}
	}
	      // System.out.println("line3");
	       s3=min;
	       can.setLast_paid_date(lastpaiddate);
	       can.setRegistered_date(s3);
	       Calendar cal=Calendar.getInstance();
	       cal.setTime(s1);
	       
	       int months1=cal.get(Calendar.MONTH);
	       int year1=cal.get(Calendar.YEAR);
	       cal.setTime(s2);
	       int months2=cal.get(Calendar.MONTH);
	       int year2=cal.get(Calendar.YEAR);
	       int n=((year2-year1)*12)+(months2-months1);
	       
	       Date s4=can.getCancel_date();
	        
	       Calendar cal1=Calendar.getInstance();
	       cal1.setTime(s3);
	       int mont1=cal1.get(Calendar.MONTH);
	       int yea1=cal1.get(Calendar.YEAR);
	       cal1.setTime(s4);
	       int mont2=cal1.get(Calendar.MONTH);
	       int yea2=cal1.get(Calendar.YEAR);
	       int m=((yea2-yea1)*12)+(mont2-mont1);
	       //System.out.println("line4");
	       if(n>3){
	    	   if(n>9){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=0;
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    	   }
	    	   else if(n==9){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.1235);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    		   
	    	   }
	    	   else if(n>=7){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.1025);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    		   
	    	   }
	    	   
	    	      else if(n>=5){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.07);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    	   }
	    	   
	       }
	       else{
	    	   if(m>3){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.1235);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    	   }
	    	   else{
	    		   double t=0;
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    		   return new ResponseEntity<String>("not eligible for cancellation as 3 months is not completed", HttpStatus.OK);
	    	   }
	       }
	       can.setCustomer_id(v.getCustomer_id());
	       can.setPolicy_id(v.getPolicy_id());
	       can.setStatus("Processing");
	       List<Cancellation> cancellist=vehicleService.getCancellationDetails(can1.getPolicy_id());
	       if(cancellist.size()!=0){
	    	   return new ResponseEntity<String>("You have already cancelled this policy ", HttpStatus.OK);
	       }
	       //System.out.println("line5");
	       can=cancelservice.save(can);
	       
		if(can==null) {
			return new ResponseEntity<String>("cancel not saved", HttpStatus.OK);

	}
		//Customer c=custService.findById(can.getCustomer_id()).get();
		
		
		return new ResponseEntity<String>("total amount paid is :"+directamount+" and last paid date is :"+max, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cancel/viewCancellation")
	public ResponseEntity<?> viewCancellation(@RequestBody Cancellation can1) {
		//Customer c=custService.findById(can1.getCustomer_id()).get();
		VehicleRegistration v=vehicleService.findById(can1.getPolicy_id()).get();
		Cancellation can=new Cancellation();
		
		//can.setRegistered_date(v.getDate_of_purchase());
		//can.setTotal_amount(Double.toString(directPayService.findTotalAmountByCustomerId(custId)));

	    Date s2=new Date();
	    Date s1=null;
	    
	    List<DirectPay> l1=vehicleService.getDirectPayDetails(can1.getPolicy_id());
		List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(can1.getPolicy_id());
		Date max=new Date();
		Calendar c1=Calendar.getInstance();
		c1.setTime(max);
		c1.set(2000, 01, 01);
		max=c1.getTime();
		Date lastpaiddate=c1.getTime();
		System.out.println("line1");
		double directamount=0;
				if(l1.size()==0){
					max=l2.get(0).getDue_date();
					for(RegisteredPay l:l2) {directamount+=Double.parseDouble(l.getPay_amount());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPaid_date())){
							lastpaiddate=l.getPaid_date();
						}
				}
				}
				else if(l2.size()==0){
					max=l1.get(0).getDue_date();
					for(DirectPay l:l1) {directamount+=(l.getAmount_paid());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPayment_date())){
							lastpaiddate=l.getPayment_date();
						}
					}
				}else{
					for(DirectPay l:l1) {directamount+=(l.getAmount_paid());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPayment_date())){
							lastpaiddate=l.getPayment_date();
						}
					}
					
					for(RegisteredPay l:l2) {directamount+=Double.parseDouble(l.getPay_amount());
						if(l.getDue_date().after(max)) {
							max=l.getDue_date();
						}
						if(lastpaiddate.before(l.getPaid_date())){
							lastpaiddate=l.getPaid_date();
						}
				}
		}

//
				
				System.out.println("line2");
	       s1=max;
	       can.setLast_paid_date(lastpaiddate);
	       Date s3=null;Date min=new Date();
	       can.setCancel_date(s2);
	       
	       can.setLast_paid_date(lastpaiddate);
	       can.setTotal_amount(Double.toString(directamount));
	       if(l1.size()==0){
				min=l2.get(0).getDue_date();
				for(RegisteredPay l:l2) {
					if(l.getPaid_date().before(min)) {
						min=l.getPaid_date();
					}
			}
			}
			else if(l2.size()==0){
				min=l1.get(0).getDue_date();
				for(DirectPay l:l1) {
					if(l.getPayment_date().before(min)) {
						min=l.getPayment_date();
					}
				}
			}else{
				for(DirectPay l:l1) {
					if(l.getPayment_date().before(min)) {
						min=l.getPayment_date();
					}
				}
				
				for(RegisteredPay l:l2) {
					if(l.getPaid_date().before(min)) {
						min=l.getPaid_date();
					}
			}
	}
	       System.out.println("line3");
	       s3=min;
	       can.setLast_paid_date(lastpaiddate);
	       can.setRegistered_date(s3);
	       Calendar cal=Calendar.getInstance();
	       cal.setTime(s1);
	       
	       int months1=cal.get(Calendar.MONTH);
	       int year1=cal.get(Calendar.YEAR);
	       cal.setTime(s2);
	       int months2=cal.get(Calendar.MONTH);
	       int year2=cal.get(Calendar.YEAR);
	       int n=((year2-year1)*12)+(months2-months1);
	       
	       Date s4=can.getCancel_date();
	        
	       Calendar cal1=Calendar.getInstance();
	       cal1.setTime(s3);
	       int mont1=cal1.get(Calendar.MONTH);
	       int yea1=cal1.get(Calendar.YEAR);
	       cal1.setTime(s4);
	       int mont2=cal1.get(Calendar.MONTH);
	       int yea2=cal1.get(Calendar.YEAR);
	       int m=((yea2-yea1)*12)+(mont2-mont1);
	       System.out.println("line4");
	       if(n>3){
	    	   if(n>9){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=0;
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    	   }
	    	   else if(n==9){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.1235);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    		   
	    	   }
	    	   else if(n>=7){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.1025);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    		   
	    	   }
	    	   
	    	      else if(n>=5){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.07);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    	   }
	    	   
	       }
	       else{
	    	   if(m>3){
	    		   String s=can.getTotal_amount();
	    		   double l= Double.parseDouble(s);
	    		   double t=l-(l*0.1235);
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    	   }
	    	   else{
	    		   double t=0;
	    		   String to=String.valueOf(t);
	    		   can.setWithdraw_amount(to);
	    		   return new ResponseEntity<String>("not eligible for cancellation as 3 months is not completed", HttpStatus.OK);
	    	   }
	       }
	       List<Cancellation> cancellist=vehicleService.getCancellationDetails(can1.getPolicy_id());
	       if(cancellist.size()!=0){
	    	   return new ResponseEntity<String>("You have already cancelled this policy ", HttpStatus.OK);
	       }
	       System.out.println("line5");
		if(can==null) {
			return new ResponseEntity<String>("cancel not saved", HttpStatus.OK);

	}
		return new ResponseEntity<String>("total amount that can be withdrawn is : "+can.getWithdraw_amount()+" last paid date is: "+lastpaiddate, HttpStatus.OK);
	}
	
	@GetMapping(value = "/cancel/findallduevehicles/")
	public ResponseEntity<?> listAllDueVehicles() {
		Date d=new Date();List<VehicleRegistration>vehicles=vehicleService.findAll();
		
		List<VehicleRegistration>duevehicles=new ArrayList<>();
		System.out.println("line1");
		System.out.println(vehicles);
		for(VehicleRegistration v:vehicles){
			System.out.println(v.getPolicy_id());
			 List<DirectPay> l1=vehicleService.getDirectPayDetails(v.getPolicy_id());
				List<RegisteredPay>l2=vehicleService.getRegisteredPayDetails(v.getPolicy_id());
				Date max=new Date();
				Calendar c=Calendar.getInstance();
				c.setTime(max);
				c.set(2000, 01, 01);
				System.out.println(l1);
				System.out.println(l2);
				System.out.println("line2");
				max=c.getTime();
						if(l1.size()==0&&l2.size()!=0){
							max=l2.get(0).getPaid_date();
							for(RegisteredPay l:l2) {
								if(l.getDue_date().after(max)) {
									max=l.getDue_date();
								}
						}
						}
						else if(l2.size()==0&&l1.size()!=0){
							max=l1.get(0).getPayment_date();
							for(DirectPay l:l1) {
								if(l.getDue_date().after(max)) {
									max=l.getPayment_date();
								}
							}
						}else if(l1.size()!=0&&l2.size()!=0){
							for(DirectPay l:l1) {
								if(l.getDue_date().after(max)) {
									max=l.getDue_date();
								}
							}
							
							for(RegisteredPay l:l2) {
								if(l.getDue_date().after(max)) {
									max=l.getDue_date();
								}
						}
				}
						System.out.println("line3");
						Calendar cal=Calendar.getInstance();
						cal.setTime(max);
						cal.add(Calendar.MONTH, 3);
						if(cal.before(d)){
							
							duevehicles.add(v);
						}
						
				
		}
		if(duevehicles.size()==0){
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}
		else{
			return new ResponseEntity<List<VehicleRegistration>>(duevehicles, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "/cancel/findall/")
	public ResponseEntity<?> listAllCancellation() {
		cancels = cancelservice.findAll();
		if (cancels.isEmpty()) {
			return new ResponseEntity<String>("No Records available in DB", HttpStatus.OK);
		}

		return new ResponseEntity<List<Cancellation>>(cancels, HttpStatus.OK);
	}

	
	@PostMapping("/cancel/usingid")
	public ResponseEntity<?> findCancellationById(@RequestBody Cancellation can) throws Exception {
		
		if(can.getCancel_id().equals("P001"))
		throw new Exception();
		
		cancel=cancelservice.findById(can.getCancel_id());
		
		if(!cancel.isPresent()) {
			//System.out.println("---- null");
			return new ResponseEntity<String>("cancel  Id  "+can.getCancel_id()+"  not found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<Cancellation>> (cancel,HttpStatus.OK);
	}
	@GetMapping("/cancel/customer/{customer_id}")
	public ResponseEntity<?> findCancellationByCustomerId(@PathVariable String customer_id) throws Exception {
		
		
		List<Cancellation>cancel=custService.getCancellationDetails(customer_id);
		
		if(cancel.size()==0) {
			
			return new ResponseEntity<String>(" You have not cancelled any policies",HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Cancellation>> (cancel,HttpStatus.OK);
	}
	
	@PutMapping(value = "/cancel/update/")
	public ResponseEntity<?> updateCancellation(@RequestBody Cancellation cancel) {
		cancel=cancelservice.save(cancel);
		
		if(cancel==null) {
			return new ResponseEntity<String>("cancel not saved", HttpStatus.OK);

		}
		
		return new ResponseEntity<Cancellation>(cancel, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/cancel/delete")
	public ResponseEntity<?> deleteCancellation(@RequestBody Cancellation can) {
		cancelservice.deleteById(can.getCancel_id());
		
		return  new ResponseEntity<String>("cancel Id with "+can.getCancel_id()+" Deleteted", HttpStatus.OK);
	}
	
	@GetMapping(value = "/cancel/approve/{cancel_id}")
	public ResponseEntity<?> approvecancellation(@PathVariable String cancel_id) {
		Cancellation tc=cancelservice.findById(cancel_id).get();
		tc.setStatus("approved");
		tc=cancelservice.save(tc);
		if(tc==null) {
			return new ResponseEntity<String>("cancellation not found", HttpStatus.OK);

		}
		//custService.deleteById(can.getCustomer_id());
	
		vehicleService.deleteById(tc.getPolicy_id());
		return new ResponseEntity<String>("Approved successfully", HttpStatus.OK);
	}
	
	@PostMapping(value = "/cancel/reject")
	public ResponseEntity<?> rejectCancellation(@RequestBody Cancellation can) {
		Cancellation tc=cancelservice.findById(can.getCancel_id()).get();
		tc.setStatus("rejected");
		tc=cancelservice.save(tc);
		if(tc==null) {
			return new ResponseEntity<String>("cancellation not found", HttpStatus.OK);

		}
		
		return new ResponseEntity<String>("Approved successfully", HttpStatus.OK);
	}
	
	}
