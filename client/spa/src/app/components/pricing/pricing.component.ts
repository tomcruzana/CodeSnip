import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pricing',
  templateUrl: './pricing.component.html',
  styleUrls: ['./pricing.component.css'],
})
export class PricingComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  plansTemp: any[] = [
    { type: 'basic', price: 0, description: 'always free!' },
    {
      type: 'pro',
      price: 4.99,
      description: 'billed Yearly. Perfect for business.',
    },
  ];
}
