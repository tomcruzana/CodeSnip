import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangepaymentFormComponent } from './changepayment-form.component';

describe('ChangepaymentFormComponent', () => {
  let component: ChangepaymentFormComponent;
  let fixture: ComponentFixture<ChangepaymentFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangepaymentFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChangepaymentFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
