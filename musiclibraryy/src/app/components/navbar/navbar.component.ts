import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginservice:LoginService) { }
  loggedin=false;
  user="";
  ngOnInit(): void {
    this.loggedin=this.loginservice.isLoggedin();
    this.user=this.loginservice.user;
  }

  logoutUser()
  {
    this.loginservice.logout();
    location.reload();
  }

}
