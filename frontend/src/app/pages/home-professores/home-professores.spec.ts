import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeProfessores } from './home-professores';

describe('HomeProfessores', () => {
  let component: HomeProfessores;
  let fixture: ComponentFixture<HomeProfessores>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeProfessores]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeProfessores);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
