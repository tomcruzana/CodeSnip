import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollectionOptionsComponent } from './collection-options.component';

describe('CollectionOptionsComponent', () => {
  let component: CollectionOptionsComponent;
  let fixture: ComponentFixture<CollectionOptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CollectionOptionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CollectionOptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
