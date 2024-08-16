import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { EmployeeService } from '../../_service/employee.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  form!: FormGroup;
  displayedColumns: string[] = ['id', 'employee_name', 'employee_salary', 'employee_age', 'employee_anual_salary'];
  dataSource = new MatTableDataSource<any>();
  employeeList: any[] = [];

  constructor(private employeeService: EmployeeService){};

  ngOnInit(): void {
    this.form = new FormGroup({'id': new FormControl(null)});
  }

  buscar(){
    if(this.form.value['id'] == null){
      this.employeeService.listar().subscribe(data =>{
        this.dataSource = new MatTableDataSource(data.data);
      });
    } else {
      this.employeeService.listarPorId(this.form.value['id']).subscribe(data =>{        
        console.log(data.data);
        this.employeeList = [data.data];
        this.dataSource = new MatTableDataSource(this.employeeList);
      });
    }
  }
}
