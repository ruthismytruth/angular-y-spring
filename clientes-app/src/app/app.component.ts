import { Component } from '@angular/core';

@Component({
  selector: 'app-root', //etiqueta html
  templateUrl: './app.component.html', //vista asociada
  styleUrls: ['./app.component.css'] //hoja de estilos
})
export class AppComponent {
  title = 'Bienvenido a Angular';
  curso: string = 'Curso Spring 5 con Angular 7';
  profesor: string = 'Andrés Guzmán';
}
