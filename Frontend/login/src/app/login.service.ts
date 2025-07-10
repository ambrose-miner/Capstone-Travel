import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
baseURL:string="http://localhost:9090/login";//double check port number
  constructor(public httpClient:HttpClient) { }

  signIn(login:any):Observable<string> {
    return this.httpClient.post(this.baseURL+ "/signIn",login,{responseType:'text'});
  }
}
