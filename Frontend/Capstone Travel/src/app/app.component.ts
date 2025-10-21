import { Component } from '@angular/core';
import { provideRouter, RouterOutlet, RouterLink, withHashLocation } from '@angular/router';
import { bootstrapApplication } from '@angular/platform-browser';
@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [RouterOutlet, RouterLink],
  // template: `
  //   <h3>Router</h3>
  //   <nav>
  //     <a routerLink="/login">Login</a> |
  //     <a routerLink="/signup">Sign Up</a>
  //   </nav>
  //   <router-outlet></router-outlet>
  //  `
})//NOTE!!!! "````````````"!!!!!
export class AppComponent {
  // logout():string{//logout function
  // sessionStorage.clear();
  // return this.routerLink.navigate(["/login"]);
  //"Property 'routerLink' does not exist on type 'app'."WTF???
//}
}
export class LoginpageComponent{}
export class SignuppageComponent{}
export class FlightBookingComponent{}

const routes = [{path:'loginpage',Component:LoginpageComponent},
  {path:'signup',Component:SignuppageComponent}]
