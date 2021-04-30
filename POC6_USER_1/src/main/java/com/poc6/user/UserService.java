package com.poc6.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired 
private UserRepository userRepository;
public Response getAllUser(){
	List<User> user= userRepository.findAll();
	if(user==null) {
		logger.error("Method for Getting All User has Failed");
		return new Response("Database is Empty",Boolean.FALSE,"Failed");
	}else {
		logger.info("Method  for Getting All User has Passed");
		return new Response("Number of Users present: "+user.size(),Boolean.TRUE,"Success");
	}
}
public Response getUserById(Integer userId){
	User user= userRepository.findByUserId(userId);
	if(user==null) 
	{
		logger.error("Method for Finding User with ID: "+userId+" has Failed");
      	return new Response("No User with Id: "+userId+" was found",Boolean.FALSE,"Failed");
	}
	else {
		logger.error("Method for Finding User with ID: "+userId+" has Passed");
		return new Response(user.getUserName()+ " with ID: "+userId+" was found",Boolean.TRUE,"Success");
	}
}
public Response getUserByEmployeeId(String employeeId){
	User user= userRepository.findByEmployeeId(employeeId);
	if(user==null) 
	{
		logger.error("User with Employee ID: "+employeeId+" was not found");
      	return new Response("No User with Employee-Id: "+employeeId+" was found",Boolean.FALSE,"Failed");
	}
	else {
		logger.info("User with EmployeeID "+employeeId+" was found");
		return new Response(user.getUserName()+ " with Employee-Id: "+employeeId+" was found",Boolean.TRUE,"Success");
	}
}
public Response getUserByName(String userName){
	User user= userRepository.findByUserName(userName);
	if(user==null) {
		logger.error("User with Name: "+userName+" was not found");
		return new Response("No of User with Name: "+userName+" was found",Boolean.FALSE,"Failed");	
	}
	else {
		logger.info("User with Name: "+userName+" was found");
		return new Response(user.getUserName()+" with ID: :"+user.getUserId()+" was found",Boolean.TRUE,"Success");
	}
}
public Response getUserByPinCode(String userPinCode){
	List<User> user= userRepository.findByUserPinCode(userPinCode);
	if(user.size()==0) 
	{
		logger.error("User with Pin-Code: "+userPinCode+" was not found");
      	return new Response("No User with Pin-Code: "+userPinCode+" was found",Boolean.FALSE,"Failed");
	}
	else {
		logger.info("User with Pin-Code: "+userPinCode+" was found");
		return new Response("Numnber of Users "+ " with Pin-Cpde: "+userPinCode+" was found "+user.size(),Boolean.TRUE,"Success");
	}
}
public Response createUser(User user){
	User user1=userRepository.findByEmployeeId(user.getEmployeeId());
	User user2=userRepository.findByucontact(user.getUcontact());
	User user3 = userRepository.findByumail(user.getUmail());
	if(user1==null && user2==null && user3==null) {
		logger.info("User "+user.getUserName()+" is Saved to the Database");
    	userRepository.save(user);
    	return new Response("User with Name : "+user.getUserName()+" and ID: "+user.getUserId()+" saved ",Boolean.TRUE,"Success");
	}
	if(user1==null && user2!=null && user3==null) {
		logger.error("User with Contact Number: "+user2.getUcontact()+" is already present");
      	return new Response("User with Contact Number: "+user2.getUcontact()+" was already found",Boolean.FALSE,"Failed");
	}
	if(user1!=null && user2==null && user3==null) {
		logger.error("User with Employee-ID: "+user1.getEmployeeId()+" is already present");
      	return new Response("User with Employee-ID: "+user1.getEmployeeId()+" was found",Boolean.FALSE,"Failed");
	}
	if(user1!=null && user2!=null && user3==null) {
		logger.error("User with Employee-ID: "+user1.getEmployeeId()+" and Contact Number: "+user1.getUcontact()+" already present");
      	return new Response("User with Employee-ID: "+user1.getEmployeeId()+" and Contact Number: "+user1.getUcontact()+" was found",Boolean.FALSE,"Failed");
	}
	if(user1!=null && user2==null && user3!=null) {
		logger.error("User with Employee-ID: "+user1.getEmployeeId()+" and Email ID:: "+user1.getUmail()+" already present");
      	return new Response("User with Employee-ID: "+user1.getEmployeeId()+" and Email ID:: "+user1.getUmail()+" was found",Boolean.FALSE,"Failed");
	}
	if(user1==null && user2!=null && user3!=null) {
		logger.error("User with Contact Number: "+user2.getUcontact()+" and Email ID: "+user3.getUmail()+" already present");
      	return new Response("User with Employee-ID: "+user2.getUcontact()+" and Email ID: "+user3.getUmail()+" was found",Boolean.FALSE,"Failed");
	}
	if(user!=null && user2!=null && user3!=null) {
		logger.error("User with Contact Number: "+user2.getUcontact()+" , Email ID: "+user3.getUmail()+" and EmployeeID: "+user1.getEmployeeId()+" already present");
      	return new Response("User with Employee-ID: "+user2.getUcontact()+" and Email ID: "+user3.getUmail()+" was found",Boolean.FALSE,"Failed");
	}
	else {
		logger.error("User with Email ID: "+user1.getUmail()+" is already present");
      	return new Response("User with Employee-ID: "+user1.getUmail()+" was found",Boolean.FALSE,"Failed");
	}
}
public Response updateUserById(User user , String employeeId) {
	User userData=userRepository.findByEmployeeId(employeeId);
	if(userData==null) {
		logger.error("User with Employee-ID: "+employeeId+" was not Present");
		return new Response("No User with Employee-ID: "+employeeId+" are found ",Boolean.FALSE,"Failed");
	}
	else {
		userData.setUserName(user.getUserName());
		userData.setLname(user.getLname());
		userData.setAge(user.getAge());
		userData.setUcontact(user.getUcontact());
		userData.setUmail(user.getUmail());
		userData.setArea(user.getArea());
		userData.setCity(user.getCity());
		userData.setUserPinCode(user.getUserPinCode());
		userData.setState(user.getState());
		userData.setCountry(user.getCountry());
		userData.setEmployeeId(user.getEmployeeId());
		userRepository.save(userData);
		logger.info("User with Employee-ID: "+employeeId+" was Updated");
		return new Response("User with Name : "+userData.getUserName()+" and ID: "+userData.getUserId()+" updated ",Boolean.TRUE,"Success");
	}
}
public Response deleteUserById(Integer userId){
	User user=userRepository.findByUserId(userId);
	if(user==null) {
		logger.error("No User with User-ID "+userId+" was found Deletion Failed");
		return new Response("No User with ID: "+userId+" are found ",Boolean.FALSE,"Failed");
	}
	else {
		logger.info("User with User-ID: "+userId+" deleted from the database");
		userRepository.deleteById(userId);
		return new Response("User with  ID: "+userId+" deleted ",Boolean.TRUE,"Success");
	}
}
public Response getUserByCity(String city) {
	List<User> users=userRepository.findByCity(city);
	if(users.size()==0) {
		logger.error("No Users found with City: "+city);
		return new Response("No Users found with City: "+city,Boolean.FALSE,"Failed");
	}
	else {
		logger.info("Numnber of users found: "+users.size());
		return new Response(users.size()+ " Users found with City: "+city,Boolean.TRUE,"Success");
	}
}
public List<User> showAllUser() throws Exception{
	List<User> user= userRepository.findAll();
	if(user.size()==0) {
		throw new UserNotFoundException("No Users Available in the Database");
	}
	else {
		return user;
	}
}
public User showUserByName(String userName) throws Exception{
	User user= userRepository.findByUserName(userName);
	if(user==null) {
		throw new UserNotFoundException("User with Name: "+userName+" not Available in the Databse");
	}
	else {
		return user;
	}
}
public User showUserById(Integer userId) throws Exception{
	User user= userRepository.findByUserId(userId);
	if(user==null) {
		throw new UserNotFoundException("User with ID: "+userId+" not available in the Database");
	}
	else {
		return user;
	}
}
public List<User> showUserByPinCode(String userPinCode) {
	List<User> user= userRepository.findByUserPinCode(userPinCode);
	if(user.size()==0) {
		throw new UserNotFoundException("User with PinCode: "+userPinCode+" not available in the Database");
	}
	else {
		return user;
	}
}
public User showUserByEmployeeId(String employeeId) {
	User user= userRepository.findByEmployeeId(employeeId);
	if(user==null) {
		throw new UserNotFoundException("User with EmployeeID: "+employeeId+" not available in the database");
	}
	else {
		return user;
	}
}
}
