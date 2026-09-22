import {Component} from '@angular/core'; import {RouterLink,RouterLinkActive,RouterOutlet} from '@angular/router';
@Component({selector:'app-root',standalone:true,imports:[RouterOutlet,RouterLink,RouterLinkActive],template:`
<header class="top"><div class="brand">ACME <span>Salary Insights</span></div><nav><a routerLink="/" routerLinkActive="active" [routerLinkActiveOptions]="{exact:true}">Dashboard</a><a routerLink="/employees" routerLinkActive="active">Employees</a></nav><div class="person">HR Manager</div></header><router-outlet/>`,
styles:[`.top{height:68px;display:flex;align-items:center;gap:30px;padding:0 28px;background:#fff;border-bottom:1px solid #e6eaf0}.brand{font-weight:850;color:#1f5eff;font-size:19px}.brand span{color:#172033}.top nav{display:flex;gap:8px;flex:1}.top a{padding:9px 12px;border-radius:8px;color:#667085;font-weight:650}.top a.active{background:#eef4ff;color:#1f5eff}.person{color:#475467;font-size:14px}`]})
export class AppComponent{}
