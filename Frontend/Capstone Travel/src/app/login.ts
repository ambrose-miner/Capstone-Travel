
export class Login {
    password: string;
    emailid: string;
    isActive: boolean;

    constructor(password: string , emailid: string , isActive: boolean){
    this.password = password;
    this.emailid = emailid;
    this.isActive = isActive;// For keeping the user logged in...?
    }
    loginStatus() {
        this.isActive = !this.isActive;// this method flips the boolean right...?
    }
}
