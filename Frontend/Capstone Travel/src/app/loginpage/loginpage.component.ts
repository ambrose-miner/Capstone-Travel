import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginService } from '../login.service';
@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent {
  loginForm = new FormGroup({
    emailid:new FormControl(''),
    password:new FormControl(''),
    usertype:new FormControl(''),
  })
  constructor(public lg:LoginService){}
  signIn():void{
    let login = this.loginForm.value;
    console.log(login);
    this.lg.signIn(login).subscribe({
      next:(result: any)=>{
        console.log(result)
      },
      error:(error: any)=>{
        console.log(error)
      },
      complete:()=>{
        console.log("login successful")
      }
    });
    this.loginForm.reset();
  }
}
