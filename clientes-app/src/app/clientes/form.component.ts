import { Component, OnInit } from '@angular/core';
import {Cliente} from "./cliente";
import { ClienteService } from "./cliente.service";
import { Router, ActivatedRoute } from '@angular/router';
import  swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  private titulo: string = "Crear cliente";
  private cliente: Cliente = new Cliente(); //ngModel del formulario puebla este objeto con los datos introducidos (binding)(mappear)

  constructor(private clienteService: ClienteService,
  private router : Router,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.cargarCliente()
  }
  cargarCliente(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.clienteService.getCliente(id).subscribe( (cliente) => this.cliente = cliente)
      }
    })
  }


  create(): void{
    this.clienteService.create(this.cliente)
    .subscribe( cliente => {
      this.router.navigate(['/clientes'])
      swal('Nuevo cliente', `Cliente ${cliente.nombre} creado con éxito`, 'success')
      }
    )
  }

  update(): void{
    this.clienteService.update(this.cliente)
    .subscribe( cliente => {
      this.router.navigate(['/clientes'])
      swal('Cliente actualizado', `Cliente ${cliente.nombre} actualizado con éxito`, 'success')
    })
  }

}
