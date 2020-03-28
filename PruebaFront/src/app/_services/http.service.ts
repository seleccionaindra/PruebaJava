import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { throwError as observableThrowError, Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

/**
 * general REST service
 */
@Injectable()
export class HttpService {

    constructor(private http: HttpClient) { }

    get(url: string, parameters?: HttpParams) {
        return this.http.get(url, {params: parameters}).pipe(
            catchError(this.handleError)
          );
    }

    post(url: string, item: object) {
        return this.http.post(url, item, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            }
        }).pipe(
            catchError(this.handleError)
        );
    }

    put(url: string, item: object) {
        return this.http.put(url, item, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            }
        }).pipe(
            catchError(this.handleError)
        );
    }

    delete(url: string) {
        return this.http.delete(url, {
            headers: {
                'Content-Type': 'application/json',
                Accept: 'application/json'
            }
        }).pipe(
            catchError(this.handleError)
        );
    }

    private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
          // A client-side or network error occurred. Handle it accordingly.
          console.error('An error occurred:', error.error.message);
        } else {
          // The backend returned an unsuccessful response code.
          // The response body may contain clues as to what went wrong,
          console.error(
            `Backend returned code ${error.status}, ` +
            `body was: ${error.error}`);
        }
        // return an observable with a user-facing error message
        return throwError(
          'Algo malo pasó, por favor intenta despues.');
      }

}
