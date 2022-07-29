import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from './employees.model';
import employees from './data/employees.json'

@Component({
  selector: 'em-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css'],
})
export class EmployeesComponent implements OnInit {
  name: string = 'EMPLOYEE MANAGEMENT SYSTEM';
  employeesd!: Employee[];
  employees: Employee[]=employees;
  filterEmployeed!: Employee[];
  filterEmployee: Employee[]=employees;
  showIcon: boolean = true;
  message: string = '';
  private _filterDesignation: string = '';

  set filterDesignation(value: string) {
    // console.log('setter fired'+value);

    this._filterDesignation = value;
    this.filteredDesignation();
  }

  get filterDesignation(): string {
    return this._filterDesignation;
  }

  constructor(private employeeService: EmployeeService) {}

  changeIcon() {
    this.showIcon = !this.showIcon;
  }

  ngOnInit(): void {

    this.employeeService.getEmployees().subscribe({
      next: (data) => {

        this.filterEmployeed = data;
        this.employeesd = this.filterEmployeed;
        console.log(this.filterEmployeed+"fgfdgdfg");
      }
    });
  }

  filteredDesignation() {
    this.filterEmployee = this.employees.filter((employee) => {
      employee.designation.includes(this.filterDesignation);

    });
  }

  onMessageReceived(value: string) {
    this.message = value;
  }
}
