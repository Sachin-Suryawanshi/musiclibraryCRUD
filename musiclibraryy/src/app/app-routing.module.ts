import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SearchmlComponent } from './components/searchml/searchml.component';
import { MusiclibraryComponent } from './musiclibrary/musiclibrary.component';
import { PaginationComponent } from './pagination/pagination.component';
import { AuthGuard } from './services/auth.guard';


const routes: Routes = [
  {
    path:'',component:HomeComponent,
    pathMatch:'full'
  },
  {
    path:"login",
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:"dashboard",
    component:DashboardComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:"insertmusiclibrary",
    component:MusiclibraryComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:"searchmusiclibrary",
    component:SearchmlComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:"pagination",
    component:PaginationComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
