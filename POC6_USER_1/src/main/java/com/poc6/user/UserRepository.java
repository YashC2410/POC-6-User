package com.poc6.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
	public User findByUserId(Integer userId);
    public User findByEmployeeId(String employeeId);
    public User findByucontact(String ucontact);
    public User findByumail(String umail);
    List<User> findByCity(String city);
    List<User> findByUserPinCode(String userPinCode);
}
