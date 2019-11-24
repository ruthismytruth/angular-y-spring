import { Component, OnInit } from '@angular/core';
import { Libro } from './libro';
import { LibroService } from "./libro.service";
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent2 implements OnInit {

  private titulo: String = "Crear Libro";
  private libro: Libro = new Libro(); //ngModel del formulario puebla este objeto con los datos introducidos (binding)(mappear)
  private errores: string[];

  constructor(private libroService: LibroService,
    private router : Router,
    private activatedRouted : ActivatedRoute) { }

  ngOnInit() {
    this.cargarLibro()
  }

  cargarLibro():void{
    this.activatedRouted.params.subscribe(params => {
      let id  = params['id']
      if(id){
        this.libroService.getLibro(id).subscribe(
          (libro) => this.libro = libro
        )
      }
    })
  }

  create(): void{
    this.libroService.create(this.libro)
    .subscribe( libro => {
        this.router.navigate(['/libros'])
        swal('Nuevo Libro', `Libro ${libro.titulo} creado con éxito`, 'success')
      },
      err => {
        this.errores = err.error.errores as string[];
        console.error('Codigo de error desde el backend' + err.status);
        console.error(err.error.errores);
      }
    );
  }

  update():void{
    this.libroService.update(this.libro).subscribe(
      json => {
        this.router.navigate(['/libros'])
        swal('Libro actualizado', `Libro ${json.libro.titulo} actualizado con exito`, "success")
      },
      err => {
        this.errores = err.error.errores as string[];
        console.error('Codigo de error desde el backend: ' + err.status);
        console.error(err.error.errores);
      }
    );
  }

}
