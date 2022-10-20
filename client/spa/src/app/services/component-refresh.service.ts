import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class ComponentRefreshService {
  constructor(private router: Router, private route: ActivatedRoute) {}

  // refreshes the component & not allowing query paramg
  resetPage() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.router.navigate(['./dashboard'], {
      relativeTo: this.route,
      queryParamsHandling: "preserve" // preserve discards new queryParams
    });
  }
}
