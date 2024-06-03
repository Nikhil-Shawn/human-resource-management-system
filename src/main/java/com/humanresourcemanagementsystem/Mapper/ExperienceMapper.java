//package com.humanresourcemanagementsystem.Mapper;
//
//import com.humanresourcemanagementsystem.Dto.ExperienceDTO;
//import com.humanresourcemanagementsystem.Entity.Employee;
//import org.mapstruct.Mapping;
//
//public class ExperienceMapper {
//    @Mapping(source = "experience.experienceID", target = "experienceID")
//    @Mapping(source = "experience.firstName", target = "firstName")
//    @Mapping(source = "experience.lastName", target = "lastName")
//    @Mapping(source = "experience.address", target = "address")
//    @Mapping(source = "experience.email", target = "email")
//    @Mapping(source = "experience.phone", target = "phone")
//    @Mapping(source = "experience.dateOfBirth", target = "dateOfBirth")
//    @Mapping(source = "experience.gender", target = "gender")
//    @Mapping(source = "experience.nationality", target = "nationality")
//    @Mapping(source = "experience.maritalStatus", target = "maritalStatus")
//    @Mapping(source = "experience.personType", target = "personType")
//    @Mapping(source = "experience.createdAt", target = "createdAt")
//    @Mapping(source = "experience.updatedAt", target = "updatedAt")
//    EmployeePersonDTO toDTO(Employee employee);
//}
