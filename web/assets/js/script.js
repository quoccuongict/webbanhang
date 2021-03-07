"use strict";
const modalContainer = document.querySelector(".modal");
const overlay = document.querySelector(".modal__overlay");
const modal = document.querySelector(".modal__body");
const registerForm = document.querySelector(".register-form");
const loginForm = document.querySelector(".login-form");
const btnRegister = document.querySelector(".register");
const btnLogin = document.querySelector(".login");
const btnsBack = document.querySelectorAll(".back");
const btnFormLogin = document.querySelector(".btn-form-login");
const navUser = document.querySelector(".header__navbar-user");

const hide = function () {
  overlay.classList.add("hidden");
  modal.classList.add("hidden");
  modalContainer.classList.add("hidden");
};

const appear = function (e) {
  e.preventDefault();
  overlay.classList.remove("hidden");
  modal.classList.remove("hidden");
  modalContainer.classList.remove("hidden");
};

const appearLogin = function (e) {
  appear(e);
  loginForm.classList.remove("hidden");
  registerForm.classList.add("hidden");
};

const appearRegister = function (e) {
  appear(e);
  registerForm.classList.remove("hidden");
  loginForm.classList.add("hidden");
};

btnRegister.addEventListener("click", appearRegister);
btnLogin.addEventListener("click", appearLogin);

overlay.addEventListener("click", hide);

btnsBack.forEach((btn) => btn.addEventListener("click", hide));

//btnFormLogin.addEventListener("click", function (e) {
//  e.preventDefault();
//  hide();
//  btnLogin.classList.add("hidden");
//  btnRegister.classList.add("hidden");
//  navUser.classList.remove("hidden");
//});
