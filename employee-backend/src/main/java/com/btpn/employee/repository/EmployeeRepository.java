package com.btpn.employee.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btpn.employee.entity.Employee;

@RestResource
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

	public Iterable<Employee> findByFirstNameContainingOrLastNameContainingAllIgnoreCase(
			@Param("firstName") String firstName, @Param("lastName") String lastName, @Param(value = "asc") Sort sort);

	@Query("select e from Employee e where (LOWER(e.lastName) like %:lastName% or LOWER(e.firstName) like %:firstName%)"
			+ "and LOWER(e.gender)=:gender")
	public Iterable<Employee> findByGenderAndSort(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("gender") String gender, @Param(value = "asc") Sort sort);

	@Query("select e from Employee e where (LOWER(e.lastName) like %:lastName% or LOWER(e.firstName) like %:firstName%)"
			+ "and e.location.id=:location")
	public Iterable<Employee> findByLocationAndSort(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("location") String location, @Param(value = "asc") Sort sort);

	@Query("select e from Employee e where (LOWER(e.lastName) like %:lastName% or LOWER(e.firstName) like %:firstName%)"
			+ "and LOWER(e.gender)=:gender and e.location.id=:location")
	public Iterable<Employee> findByLocationGenderAndSort(@Param("firstName") String firstName,
			@Param("lastName") String lastName, @Param("gender") String gender, @Param("location") String location,
			@Param(value = "asc") Sort sort);

	@Transactional
	public String deleteByEmpId(String empId);

}
