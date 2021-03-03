import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
authRequest={
  username:"",
  password:""
}
  constructor(private loginservice:LoginService) { }

  ngOnInit(): void {
  }
  onSubmit()
  {
    
    if((this.authRequest.username!='' && this.authRequest.password!='') && (this.authRequest.username!=null && this.authRequest.password!=null))
    {
      console.log("Logged in");
      this.loginservice.generateToken(this.authRequest).subscribe((data)=>
      {
        console.log(data);
        this.loginservice.loginuser(data);
        window.location.href="/dashboard";
      },
      err=>
      {
        console.log(err);
      })

    }
    else
    {
      console.log("fields are required");
    }
  }

}
