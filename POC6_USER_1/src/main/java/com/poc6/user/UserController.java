package com.poc6.user;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users1")
public class UserController {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired 
private UserService userService;
@GetMapping("/showAllUser")
public List<User> showAllUser() throws Exception{
	logger.info("Show All User Method is Called");
	return userService.showAllUser();
}
@GetMapping("/showUserByName/{userName}")
public User showUserByName(@PathVariable (value="userName") String userName) throws Exception{
	logger.info("Show User with Name: "+userName+" is Called");
	return userService.showUserByName(userName);
}
@GetMapping("/showUserById/{userId}")
public User showUserById(@PathVariable (value="userId") Integer userId) throws Exception{
	logger.info("Show User wiht ID: "+userId+"is Called");
	return userService.showUserById(userId);
}
@GetMapping("/showUserByPinCode/{userPinCode}")
public List<User> showUserByPinCode(@PathVariable (value="userPinCode") String userPinCode) {
	logger.info("Show User with PinCode: "+userPinCode+" is Called");
	return userService.showUserByPinCode(userPinCode);
}
@GetMapping("/showUserByEmployeeId/{employeeId}")
public User showEmployeeById(@PathVariable (value="employeeId") String employeeId) {
	logger.info("Show User with Employee-ID :"+employeeId+" is called");
	return userService.showUserByEmployeeId(employeeId);
}
@GetMapping("/getAllUser")
public Response getAllUser() {
	logger.info("Get All Users Method is Callled");
	return userService.getAllUser();
}
@GetMapping("/city/{city}")
public Response getUserByCity(@PathVariable (value="city") String city){
	return userService.getUserByCity(city);
}
@GetMapping("/name/{userName}")
public Response getUserByName(@PathVariable (value="userName") String userName) {
	logger.info("Get User By Name :"+userName+" is called");
	return userService.getUserByName(userName);
}
@GetMapping("/id/{userId}")
public Response getUserById(@PathVariable (value="userId") Integer userId) {
	logger.info("Get User By ID :"+userId+" is called");
	return userService.getUserById(userId);
}
@GetMapping("/pincode/{userPinCode}")
public Response getUserByPinCode(@PathVariable (value="userPinCode") String userPinCode) {
	logger.info("Get User By Pin-Code :"+userPinCode+" is called");
	return userService.getUserByPinCode(userPinCode);
}
@GetMapping("/empid/{employeeId}")
public Response getUserByemployeeId(@PathVariable (value="employeeId") String employeeId) {
	logger.info("Get User By Employee-ID :"+employeeId+" is called");
	return userService.getUserByEmployeeId(employeeId);
}
@PostMapping("/createUser")
public Response creatUser(@Valid @RequestBody User user) {
	logger.info("Create New User Method is initiated");
	return userService.createUser(user);
}
@PutMapping("/updateUser/{employeeId}")
public Response updateUserById(@Valid @RequestBody User userData , @PathVariable (value="employeeId") String employeeId) {
	logger.info("User with ID "+employeeId+" and name "+userData.getUserName()+" is called for updation");;
	return userService.updateUserById(userData, employeeId);
}
@DeleteMapping("/deleteUser/{userId}")
public Response deleteUserById(@PathVariable (value="userId") Integer userId) {
	logger.info("User with ID: "+userId+" is called for Deletion");
	return userService.deleteUserById(userId);
}
}