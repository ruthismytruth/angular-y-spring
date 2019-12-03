import { Component, OnInit } from '@angular/core';
import { Libro } from './libro.js';
import { LibroService } from './libro.service';
import swal from 'sweetalert2';
import { tap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.css']
})
export class LibrosComponent implements OnInit {

  libros: Libro[];
  paginador: any;
  isClientes: boolean;

  constructor(private libroService: LibroService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.isClientes =  false;
    this.activatedRoute.paramMap.subscribe(params => {
      let page: number = +params.get('page');
      if(!page){
        page = 0;
      }
      this.libroService.getLibros(page).pipe(
        tap(response => {
          this.libros = response.content as Libro[];
          this.paginador = response;
        })
      ).subscribe();

    })   
  }

  delete(libro : Libro) : void{
    swal({
      title: '¿Está seguro?',
      text: `Se va a eliminar a ${libro.titulo} de ${libro.autor}`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      confirmButtonText: 'Sí, eliminar!',
      cancelButtonText: 'No, cancelar!',
      buttonsStyling: false,
      reverseButtons: true
    }).then((result) => {
      if (result.value) {
        this.libroService.delete(libro.id).subscribe(
          response => {
            this.libros = this.libros.filter(lib => lib !== libro )
            swal(
              'Libro Eliminado!',
              `Libro ${libro.titulo} eliminado con exito`,
              'success'
            )
          }
        )
      }
    })
  }

}
