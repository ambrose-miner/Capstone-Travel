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
  })
  constructor(public lg:LoginService){}
  signIn():void{
    let user = this.loginForm.value;
    console.log(user);
    this.lg.signIn(user).subscribe({
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
