package com.btpn.empolyee.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.btpn.empolyee.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

	public Iterable<Employee> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(
			@Param("firstName") String firstName, @Param("lastName") String lastName, @Param(value = "asc") Sort sort);

	@Query("select e from Employee e where (UPPER(e.lastName) like %:lastName% or UPPER(e.firstName) like %:firstName%)"
			+ "and UPPER(e.gender)=:gender")
	public Iterable<Employee> findByGenderAndSort(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("gender") String gender, @Param(value = "asc") Sort sort);

	@Query("select e from Employee e where (UPPER(e.lastName) like %:lastName% or UPPER(e.firstName) like %:firstName%)"
			+ "and UPPER(e.location.id)=:location")
	public Iterable<Employee> findByLocationAndSort(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("location") String location, @Param(value = "asc") Sort sort);

	@Query("select e from Employee e where (UPPER(e.lastName) like %:lastName% or UPPER(e.firstName) like %:firstName%)"
			+ "and UPPER(e.gender)=:gender and UPPER(e.location.id)=:location")
	public Iterable<Employee> findByLocationGenderAndSort(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("gender") String gender, @Param("location") String location,
			@Param(value = "asc") Sort sort);

	@Transactional
	public String deleteByEmpId(String empId);

}
