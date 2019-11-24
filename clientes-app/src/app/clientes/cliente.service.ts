import { Injectable } from '@angular/core';
import { CLIENTES } from './cliente.json';
import { Cliente } from './cliente'; //importamos la clase
import { of, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import swal from 'sweetalert2';

import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndPoint:string = "http://localhost:8080/api/clientes";

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient, private router : Router) { }

  getClientes(): Observable<Cliente[]>{
    //return of(CLIENTES);
    return this.http.get<Cliente[]>(this.urlEndPoint); //devuelve JSON (tipo any) y le hacemos un cast a Cliente[]
    //return this.http.get(this.urlEndePoint).pipe(
      //map( (response) => response as Cliente[] )
    //);
  }

  create(cliente: Cliente) : Observable<Cliente> {
    return this.http.post(this.urlEndPoint, cliente, {headers: this.httpHeaders}).pipe(
      map( (response: any) => response.cliente as Cliente),
      catchError(e => {
        if(e.status ==400){
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal('Error al crear', e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  getCliente(id) : Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError (e => {
        this.router.navigate(['/clientes']);
        console.error(e.error.mensaje);
        swal('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  update(cliente : Cliente) : Observable<any>{
    return this.http.put<any>(`${this.urlEndPoint}/${cliente.id}`, cliente, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        if(e.status ==400){
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal('Error al crear', e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id) :Observable<Cliente>{
    return this.http.delete<Cliente>(`${this.urlEndPoint}/${id}`, {headers : this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal('Error al crear', e.error.error, 'error');
        return throwError(e);
      })
    );
  }
}
