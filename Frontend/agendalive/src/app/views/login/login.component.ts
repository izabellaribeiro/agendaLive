import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  title = 'angulartoastr';
  showModalRegister!: boolean;
  showModalLogin!:boolean;
  showModalForgot!: boolean;
  registerForm!: FormGroup;
  loginForm!: FormGroup;
  forgotForm!: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder) { }

  showLogin()
  {
    this.showModalLogin = true;
 
    
  }
  hideLogin()
  {
    this.showModalLogin = false;
    this.submitted = false;
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]]
    

  });
 
  }

  showRegister()
  {
    this.showModalRegister = true; 


  }  

  hideRegister()
  {
    this.showModalRegister = false;
    this.submitted = false;

    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      firstname: ['', [Validators.required]]

  });



  }

  showForgot()
  {
    this.showModalForgot = true; 
    
    
  }
  hideForgot()
  {
    this.showModalForgot = false;
    this.submitted = false;
    this.forgotForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],

  });
    
  
  }
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(6)]]
    });
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      firstname: ['', [Validators.required]]
  });

    this.forgotForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
  });
  }

get f() { return this.loginForm.controls; }


onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
        return;
    }
    if(this.submitted)
    {
      this.showModalLogin = false;
    }
   
}
 
}