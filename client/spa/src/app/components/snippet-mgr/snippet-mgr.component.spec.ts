import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SnippetMgrComponent } from './snippet-mgr.component';

describe('SnippetMgrComponent', () => {
  let component: SnippetMgrComponent;
  let fixture: ComponentFixture<SnippetMgrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SnippetMgrComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SnippetMgrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
