import { compileNgModuleFromRender2 } from "@angular/compiler/src/render3/r3_module_compiler";
import { RouterModule, Routes} from '@angular/router';

import { BodyComponent } from './components/body/body.component';
import { FormComponent } from './components/form/form.component';

const APP_ROUTES: Routes = [
    {path:'', redirectTo: '/personas', pathMatch: 'full'},
    {path:'form', component: FormComponent},
    {path:'personas', component: BodyComponent},
    {path:'form/:cedula', component: FormComponent}

];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);