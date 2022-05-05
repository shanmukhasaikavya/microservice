import axios from 'axios';
import { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { Button } from 'react-bootstrap';
import { Link } from 'react-router-dom';


class Employees extends Component {

    state = {
        employees: [],
        isAddNew: false,
        isDeleted: false,
        isUpdated: false,
        employee: null,
    };


    componentDidMount = async () => {
        fetch("http://localhost:8080/employees/").then((response) =>{
            response.json().then((data) => this.setState({ employees: data}));
        });

        const response = await axios.get(
            "http://localhost:8080/employees/"
        );
        this.setState({ employees: response.data});
        console.log(response.data);
    };

    addNewHandler = () => {
        this.setState({ isAddNew: true });
    };

   
    deleteEmployee = async (id) => {
        let response = window.confirm(
            "Do you really want to delete the employee with the Id "+ id + " ?"
        );
        if(response){
            let response = await axios.delete(
                "http://localhost:8080/employees/" + id
            );
            console.log("deleted");
            response = await axios.get(
                "http://localhost:8080/employees/"
            );
            this.setState({ employees: response.data});
        };
    };
    componentWillUnmount() {}
    updateEmployee = async (id) => {
        console.log("Id = "+id);
        this.setState({ isUpdated: true });
        const response = await axios.get(
            "http://localhost:8080/employees"+id
        );
        const employee = await response.data;
        this.setState({ employee: employee });
        console.log("Employee : "+ employee );
    };

    render(){
        if(this.state.isAddNew){
            console.log('add');
            <Link to="/add" />
        };
        if(this.state.isUpdated){
            return <Link to="/update" />
        };
        return(
           
            <div className="container col-8">
                <br />
                <h3 className="text-primary">Employee List</h3>
                <Link to='/add'><Button onClick={this.addNewHandler}>Add New</Button></Link>
             
                <br />
                <br />
                <table className="table table-striped table-bordered">
                    <thead className='table-bordered'>
                        <tr>
                            <th>Employee Id</th>
                            <th>Name</th>
                            <th>Gender </th>
                            <th>Age </th>
                            <th>Salary </th>
                            <th style={{ width: 200}}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.employees.map((x) =>(
                            <tr key={x.id}>
                                <td>{x.id}</td>
                                <td>{x.name}</td>
                                <td>{x.gender}</td>
                                <td>{x.age}</td>
                                <td>{x.salary}</td>
                                <td>
                                    <Button onClick = {()=> this.deleteEmployee(x.id)}>
                                        Delete
                                    </Button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        );
    };
};

export default Employees;