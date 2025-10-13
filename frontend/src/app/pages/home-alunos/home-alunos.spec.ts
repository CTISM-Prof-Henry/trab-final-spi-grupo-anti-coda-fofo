import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAlunos } from './home-alunos';

describe('HomeAlunos', () => {
  let component: HomeAlunos;
  let fixture: ComponentFixture<HomeAlunos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeAlunos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeAlunos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
