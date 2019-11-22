import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DirectivaComponent } from './directiva/directiva.component';
import { ClientesComponent } from './clientes/clientes.component'; //solo el nombre del archivo sin la extension
import { ClienteService } from './clientes/cliente.service';
import { LibrosComponent } from './libros/libros.component';
import { FormComponent } from './clientes/form.component';
import { FormComponent2 } from './libros/form.component';
import { LibroService } from './libros/libro.service';

const routes: Routes = [
  {path: '', redirectTo: '/clientes', pathMatch: 'full'},
  {path: 'directivas', component: DirectivaComponent},
  {path: 'clientes', component: ClientesComponent},
  {path: 'libros', component:LibrosComponent},
  {path: 'clientes/form', component:FormComponent},
  {path: 'clientes/form/:id', component:FormComponent},
  {path: 'libros/form', component:FormComponent2 },
  {path: 'libros/form/:id', component:FormComponent2}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,
    ClientesComponent,
    LibrosComponent,
    FormComponent,
    FormComponent2
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ClienteService, LibroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
