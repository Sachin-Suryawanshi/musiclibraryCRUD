import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url="http://localhost:8080";
  constructor(private http:HttpClient) { }
  user="";
  public generateToken(authrequest:any)
  {
    this.user=authrequest.username;
    return this.http.post("http://localhost:8080/authenticate",authrequest,{responseType:'text' as 'json'});
  }
  loginuser(token:any)
  {
    localStorage.setItem("token",token);
    return true;
  }

  isLoggedin()
  {
   let token= localStorage.getItem("token");
   if(token==undefined || token==='' || token==null)
   {
     return false;
   }
   else 
   {
     return true;
   }
  }
  logout()
  {
    localStorage.removeItem("token");
    
  }
  getToken()
  {
    return localStorage.getItem("token");
  }
}
