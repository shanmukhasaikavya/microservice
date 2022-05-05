import { Button } from 'react-bootstrap';
import React, { Component, useRef, useState } from 'react';
import axios from 'axios';
import {Redirect} from "react-router-dom";
import { useNavigate } from "react-router-dom";


import { Link, Navigate } from 'react-router-dom';
import Employees from './Employees';

const AddEmployee = (props) => {
    const[addStatus,setAddStatus]=useState(false);
    const[isCancel,setIsCancel]=useState(false);
    const idInputRef=useRef();
    const nameInputRef=useRef();
    const genderInputMaleRef=useRef();
    const gederInputFemaleRef=useRef();
    const genderValue="";
    const ageInputRef=useRef();
    const salaryInputRef=useRef();
    let gender=undefined;

   
    let navigate = useNavigate();
   
    const addEmployee=async(event)=>{
        event.preventDefault();
   

        const employee={
            id:idInputRef.current.value,
            name:nameInputRef.current.value,
            gender,
            age:ageInputRef.current.value,
            salary:salaryInputRef.current.value

        };


       let response=await axios.post(
           "http://localhost:8080/employees/",
           employee
       );
       console.log(employee);
       setAddStatus(true);
};
const handleChange=(e)=>{
    let genderValue=e.target.value;
    gender=genderValue;
    console.log("Gender value" +gender);
}

const cancelAdd=()=>{
    setIsCancel(true);
};


if(addStatus){
    navigate("/");
}

if(isCancel){
    <link to="/employees"></link>
}


            return (
                <div className='container'>
                <h3 className='text-primary'>Add Employee</h3>
                    <form onSubmit={addEmployee}>
                       
                    <div className="form-group col-3">
                        <label className="fw-bold">Employee Id</label>
                        <input
                        type="text"
                        name="id"
                        className="form-control"
                        ref={idInputRef}
                        />
                    </div>
                        <br />
                    <div className="form-group col-3">
                        <label className="fw-bold">Name</label>
                        <input
                        type="text"
                        name="name"
                        className="form-control"
                        ref={nameInputRef}
                        />
                    </div>
                    <br />
                    <div className="form-group col-3">
                        <label className="fw-bold">Gender</label>
                        &nbsp; &nbsp;
                        <input
                        type="radio"
                        name="gender"
                        className="form-check-input"
                        value="Male"
                        ref={genderInputMaleRef}
                        onChange={handleChange}
                        />
                        <label className="form-check-label">Male</label>
                        <input
                        type="radio"
                        name="gender"
                        className="form-check-input" 
                        value="Female"
                        ref={gederInputFemaleRef}
                        onChange={handleChange}
                        />
                        <label className="form-check-label">Female</label>
                    </div>
                    <br />
                    <div className="form-group col-3">
                        <label className="fw-bold">Age</label>
                        <input
                        type="number"
                        name="age"
                        className="form-control"
                        ref={ageInputRef}
                        />
                    </div>
                    <br />
                    <div className="form-group col-3">
                        <label className="fw-bold">Salary</label>
                        <input
                        type="number"
                        name="salary"
                        className="form-control"
                        ref={salaryInputRef}
                        />
                    </div>
                    <br />
                    <Button type="submit">Add</Button>&nbsp; &nbsp;
                    <Button onClick={cancelAdd}>Cancel</Button>
                   
                    </form>
                </div>  
            );
};

export default AddEmployee;