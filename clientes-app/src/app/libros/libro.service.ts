import { Injectable } from '@angular/core';
import { Libro } from './libro';
import { Observable, throwError } from 'rxjs';
import { map, catchError }  from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import swal from 'sweetalert2';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private urlEndPoint:string = "http://localhost:8080/api/libros";
  private httpHeaders = new HttpHeaders ({'Content-type': 'application/json'})
  
  constructor(private http: HttpClient, private router: Router) { }

  getLibros(): Observable<Libro[]>{
    return this.http.get<Libro[]>(this.urlEndPoint);
  }

  create(libro : Libro) : Observable<Libro>{
    return this.http.post(this.urlEndPoint, libro, {headers: this.httpHeaders}).pipe(
      map( (response: any) => response.libro as Libro),
      catchError(e => {
        if(e.status == 400){
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal('Error al crear ', e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  getLibro(id) : Observable<Libro>{
    return this.http.get<Libro>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/libros']);
        console.error(e.error.mensaje);
        swal('Error al acceder', e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  update(libro : Libro) : Observable<any>{
    return this.http.put<any>(`${this.urlEndPoint}/${libro.id}`, libro, {headers: this.httpHeaders} ).pipe(
      map( (response: any) => response.libro as Libro),
      catchError(e => {
        if(e.status == 400){
          return throwError(e);
        }
        console.error(e.error.mensaje);
        swal('Error al actualizar ', e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  delete(id) : Observable<Libro> {
    return this.http.delete<Libro>(`${this.urlEndPoint}/${id}`, {headers : this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal('Error al editar', e.error.error, 'error');
        return throwError(e);
      })
    )
  }
}
