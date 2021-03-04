import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component'
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {FormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http'
import { LoginService } from './services/login.service';
import { AuthGuard } from './services/auth.guard';
import { AuthInterceptor } from './services/auth.interceptor';
import { MusiclibraryComponent } from './musiclibrary/musiclibrary.component';
import { SearchmlComponent } from './components/searchml/searchml.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PaginationComponent } from './pagination/pagination.component'
import {InfiniteScrollModule} from 'ngx-infinite-scroll';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    DashboardComponent,
    HomeComponent,
    MusiclibraryComponent,
    SearchmlComponent,
    PaginationComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,MatToolbarModule,FormsModule,
    HttpClientModule,
    MatPaginatorModule,
    InfiniteScrollModule
  ],
  providers: [LoginService,AuthGuard,[{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true}]],
  bootstrap: [AppComponent]
})
export class AppModule { }
