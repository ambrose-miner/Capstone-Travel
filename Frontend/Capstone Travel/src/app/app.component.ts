import { Component } from '@angular/core';
import { provideRouter, RouterOutlet, RouterLink, withHashLocation } from '@angular/router';
import { bootstrapApplication } from '@angular/platform-browser';
@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [RouterOutlet, RouterLink],
  
})
export class AppComponent {
  //******************************************
  // //This is the error seen from inspect ellement on browser

//core.mjs:10614 ERROR RuntimeError: NG0403: The module AppModule was
//  bootstrapped, but it does not declare "@NgModule.bootstrap"
//  components nor a "ngDoBootstrap" method. Please define one of these. Find more at 
//********************************************

//   AppComponent.bootstrapApplication(AppComponent: any, { providers: [provideRouter] }: {
//     providers: [any];
// }): any
}
  //  bootstrapApplication(AppComponent:any, {
  //   providers:[
  //     provideRouter(routes),
  //   ],
   
  
  // logout():string{//logout function
  // sessionStorage.clear();
  // return this.routerLink.navigate(["/login"]);
  //"Property 'routerLink' does not exist on type 'app'."WTF???
//}

