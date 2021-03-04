import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private loginservice:LoginService) { }
 loggedin=false;
  ngOnInit(): void {
    this.loggedin=this.loginservice.isLoggedin();
  }


}
