import { Injectable } from '@angular/core';
import { Libro } from './libro';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LibroService {

  private urlEndPoint:string = "http://localhost:8080/api/libros";
  private httpHeaders = new HttpHeaders ({'Content-type': 'application/json'})
  
  constructor(private http: HttpClient) { }

  getLibros(): Observable<Libro[]>{
    return this.http.get<Libro[]>(this.urlEndPoint);
  }

  create(libro : Libro) : Observable<Libro>{
    return this.http.post<Libro>(this.urlEndPoint, libro, {headers: this.httpHeaders});
  }

  getLibro(id) : Observable<Libro>{
    return this.http.get<Libro>(`${this.urlEndPoint}/${id}`);
  }

  update(libro :Libro) : Observable<Libro>{
    return this.http.put<Libro>(`${this.urlEndPoint}/${libro.id}`, libro, {headers: this.httpHeaders} )
  }

  delete(id) : Observable<Libro> {
    return this.http.delete<Libro>(`${this.urlEndPoint}/${id}`, {headers : this.httpHeaders})
  }
}
