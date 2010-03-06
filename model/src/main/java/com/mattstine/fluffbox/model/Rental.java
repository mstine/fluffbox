/*
 * Copyright (c) 2010 Matt Stine
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mattstine.fluffbox.model;

import java.util.Date;

public class Rental {

    private Long id;
    private Speaker speaker;
    private Kiosk kioskRentedFrom;
    private Customer customer;
    private Date dateReserved;
    private Date datePickedUp;
    private Date dateDue;
    private Date dateReturned;
    private Kiosk kioskReturnedTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Kiosk getKioskRentedFrom() {
        return kioskRentedFrom;
    }

    public void setKioskRentedFrom(Kiosk kioskRentedFrom) {
        this.kioskRentedFrom = kioskRentedFrom;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateReserved() {
        return dateReserved;
    }

    public void setDateReserved(Date dateReserved) {
        this.dateReserved = dateReserved;
    }

    public Date getDatePickedUp() {
        return datePickedUp;
    }

    public void setDatePickedUp(Date datePickedUp) {
        this.datePickedUp = datePickedUp;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Kiosk getKioskReturnedTo() {
        return kioskReturnedTo;
    }

    public void setKioskReturnedTo(Kiosk kioskReturnedTo) {
        this.kioskReturnedTo = kioskReturnedTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (customer != null ? !customer.equals(rental.customer) : rental.customer != null) return false;
        if (dateDue != null ? !dateDue.equals(rental.dateDue) : rental.dateDue != null) return false;
        if (datePickedUp != null ? !datePickedUp.equals(rental.datePickedUp) : rental.datePickedUp != null)
            return false;
        if (dateReserved != null ? !dateReserved.equals(rental.dateReserved) : rental.dateReserved != null)
            return false;
        if (dateReturned != null ? !dateReturned.equals(rental.dateReturned) : rental.dateReturned != null)
            return false;
        if (id != null ? !id.equals(rental.id) : rental.id != null) return false;
        if (kioskRentedFrom != null ? !kioskRentedFrom.equals(rental.kioskRentedFrom) : rental.kioskRentedFrom != null)
            return false;
        if (kioskReturnedTo != null ? !kioskReturnedTo.equals(rental.kioskReturnedTo) : rental.kioskReturnedTo != null)
            return false;
        if (speaker != null ? !speaker.equals(rental.speaker) : rental.speaker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (speaker != null ? speaker.hashCode() : 0);
        result = 31 * result + (kioskRentedFrom != null ? kioskRentedFrom.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (dateReserved != null ? dateReserved.hashCode() : 0);
        result = 31 * result + (datePickedUp != null ? datePickedUp.hashCode() : 0);
        result = 31 * result + (dateDue != null ? dateDue.hashCode() : 0);
        result = 31 * result + (dateReturned != null ? dateReturned.hashCode() : 0);
        result = 31 * result + (kioskReturnedTo != null ? kioskReturnedTo.hashCode() : 0);
        return result;
    }
}
