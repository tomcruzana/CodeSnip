import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DocumentationComponent } from './components/documentation/documentation.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { PricingComponent } from './components/pricing/pricing.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { ShareComponent } from './components/share/share.component';
import { SnippetMgrComponent } from './components/snippet-mgr/snippet-mgr.component';
import { UserAuthGuard } from './routeguards/userauth.guard';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'documentation', component: DocumentationComponent },
  { path: 'pricing', component: PricingComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'dashboard',
    component: SnippetMgrComponent,
    canActivate: [UserAuthGuard],
  },
  {
    path: 'profile',
    component: ProfileComponent,
    canActivate: [UserAuthGuard],
  },
  {
    path: 'share',
    component: ShareComponent,
    canActivate: [UserAuthGuard],
  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
