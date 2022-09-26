import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmgrSidebarComponent } from './smgr-sidebar.component';

describe('SmgrSidebarComponent', () => {
  let component: SmgrSidebarComponent;
  let fixture: ComponentFixture<SmgrSidebarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SmgrSidebarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmgrSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
