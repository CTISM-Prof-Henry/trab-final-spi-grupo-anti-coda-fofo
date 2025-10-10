import { bootstrapApplication } from '@angular/platform-browser';
import { App}  from './app/app';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes'; // <-- AQUI: com { routes }

bootstrapApplication(App, {
  providers: [provideRouter(routes)]
});
