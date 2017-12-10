package io.khasang.training_hotel.dto;

import io.khasang.training_hotel.entity.Car;
import io.khasang.training_hotel.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class CarDTO {
    private Long id;
    private String model;
    private LocalDate year;

    private Set<EmployeeDTO> employeeSet = new HashSet<>();

    public CarDTO getCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setModel(car.getModel());
        carDTO.setYear(car.getYear());

        Set<EmployeeDTO> employeeDTOSet = new HashSet<>();

        for (Employee employee : car.getEmployeeSet()) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTOSet.add(employeeDTO);
        }

        carDTO.setEmployeeSet(employeeDTOSet);

        return carDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public Set<EmployeeDTO> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<EmployeeDTO> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
