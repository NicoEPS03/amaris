import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private url = `http://localhost:8080/employee`;

  constructor(private http: HttpClient) { }

  listarPorId(idEmployee: string) {
    return this.http.get<any>(`${this.url}/getEmployee/${idEmployee}`);
  }

  listar() {
    return this.http.get<any>(`${this.url}/getEmployees`);
  }
}
