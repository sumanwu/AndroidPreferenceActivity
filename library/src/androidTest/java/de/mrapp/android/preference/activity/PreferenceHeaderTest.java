/*
 * Copyright 2014 - 2016 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.mrapp.android.preference.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.content.ContextCompat;
import android.test.AndroidTestCase;

import junit.framework.Assert;

/**
 * Tests the functionality of the class {@link PreferenceHeader}.
 *
 * @author Michael Rapp
 */
public class PreferenceHeaderTest extends AndroidTestCase {

    /**
     * Tests, if all properties are set correctly by the constructor, which allows to pass the
     * preference header's title as an instance of the class {@link CharSequence}.
     */
    public final void testConstructorWithCharSequenceParameter() {
        CharSequence title = "title";
        PreferenceHeader preferenceHeader = new PreferenceHeader(title);
        assertEquals(title, preferenceHeader.getTitle());
        assertNull(preferenceHeader.getSummary());
        assertNull(preferenceHeader.getFragment());
        assertNull(preferenceHeader.getBreadCrumbTitle());
        assertNull(preferenceHeader.getBreadCrumbShortTitle());
        assertNull(preferenceHeader.getIntent());
        assertNull(preferenceHeader.getExtras());
        assertNull(preferenceHeader.getIcon());
    }

    /**
     * Ensures, that a {@link NullPointerException} is thrown by the constructor, which allows to
     * pass the preference header's title as an instance of the class {@link CharSequence}, if the
     * title is null.
     */
    public final void testConstructorWithCharSequenceParameterThrowsExceptionWhenTitleIsNull() {
        try {
            new PreferenceHeader(null);
            Assert.fail();
        } catch (NullPointerException e) {
            return;
        }
    }

    /**
     * Ensures, that an {@link IllegalArgumentException} is thrown by the constructor, which allows
     * to pass the preference header's title as an instance of the class {@link CharSequence}, if
     * the title is empty.
     */
    public final void testConstructorWithCharSequenceParameterThrowsExceptionWhenTitleIsEmpty() {
        try {
            new PreferenceHeader("");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    /**
     * Tests, if all properties are set correctly by the constructor, which allows to pass the
     * preference header's title as a resource id.
     */
    public final void testConstructorWithResourceIdParameter() {
        PreferenceHeader preferenceHeader =
                new PreferenceHeader(getContext(), android.R.string.cancel);
        assertEquals(getContext().getString(android.R.string.cancel), preferenceHeader.getTitle());
        assertNull(preferenceHeader.getSummary());
        assertNull(preferenceHeader.getFragment());
        assertNull(preferenceHeader.getBreadCrumbTitle());
        assertNull(preferenceHeader.getBreadCrumbShortTitle());
        assertNull(preferenceHeader.getIntent());
        assertNull(preferenceHeader.getExtras());
        assertNull(preferenceHeader.getIcon());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's title and
     * expects an instance of the class {@link CharSequence} as a parameter.
     */
    public final void testSetTitleWithCharSequenceParameter() {
        CharSequence title = "title";
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setTitle(title);
        assertEquals(title, preferenceHeader.getTitle());
    }

    /**
     * Ensures, that a {@link NullPointerException} is thrown by the method, which allows to set the
     * preference header's title and expects an instance of the class {@link CharSequence} as a
     * parameter, if the title is null.
     */
    public final void testSetTitleWithCharSequenceParameterThrowsExceptionWhenTitleIsNull() {
        try {
            PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
            preferenceHeader.setTitle(null);
            Assert.fail();
        } catch (NullPointerException e) {
            return;
        }
    }

    /**
     * Ensures, that an {@link IllegalArgumentException} is thrown by the method, which allows to
     * set the preference header's title and expects an instance of the class {@link CharSequence}
     * as a parameter, if the title is empty.
     */
    public final void testSetTitleWithCharSequenceParameterThrowsExceptionWhenTitleIsEmpty() {
        try {
            PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
            preferenceHeader.setTitle("");
            Assert.fail();
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's title and
     * expects a resource id as a parameter.
     */
    public final void testSetTitleWithResourceIdParameter() {
        int resourceId = android.R.string.cancel;
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setTitle(getContext(), resourceId);
        assertEquals(getContext().getString(resourceId), preferenceHeader.getTitle());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's summary
     * and expects an instance of the class {@link CharSequence} as a parameter.
     */
    public final void testSetSummaryWithCharSequenceParameter() {
        CharSequence summary = "summary";
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setSummary(summary);
        assertEquals(summary, preferenceHeader.getSummary());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's summary
     * and expects a resource id as a parameter.
     */
    public final void testSetSummaryWithResourceIdParameter() {
        int resourceId = android.R.string.cancel;
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setSummary(getContext(), resourceId);
        assertEquals(getContext().getString(resourceId), preferenceHeader.getSummary());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's bread
     * crumb title and expects an instance of the class {@link CharSequence} as a parameter.
     */
    public final void testSetBreadCrumbTitleWithCharSequenceParameter() {
        CharSequence breadCrumbTitle = "breadCrumbTitle";
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setBreadCrumbTitle(breadCrumbTitle);
        assertEquals(breadCrumbTitle, preferenceHeader.getBreadCrumbTitle());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's bread
     * crumb title and expects a resource id as a parameter.
     */
    public final void testSetBreadCrumbTitleWithResourceIdParameter() {
        int resourceId = android.R.string.cancel;
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setBreadCrumbTitle(getContext(), resourceId);
        assertEquals(getContext().getString(resourceId), preferenceHeader.getBreadCrumbTitle());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's bread
     * crumb short title and expects an instance of the class {@link CharSequence} as a parameter.
     */
    public final void testSetBreadCrumbShortTitleWithCharSequenceParameter() {
        CharSequence breadCrumbShortTitle = "breadCrumbShortTitle";
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setBreadCrumbShortTitle(breadCrumbShortTitle);
        assertEquals(breadCrumbShortTitle, preferenceHeader.getBreadCrumbShortTitle());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's bread
     * crumb short title and expects a resource id as a parameter.
     */
    public final void testSetBreadCrumbShortTitleWithResourceIdParameter() {
        int resourceId = android.R.string.cancel;
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setBreadCrumbShortTitle(getContext(), resourceId);
        assertEquals(getContext().getString(resourceId),
                preferenceHeader.getBreadCrumbShortTitle());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's icon and
     * expects a drawable as a parameter.
     */
    public final void testSetIconWithDrawableParameter() {
        Drawable icon = ContextCompat.getDrawable(getContext(), android.R.drawable.ic_delete);
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setIcon(icon);
        assertEquals(icon, preferenceHeader.getIcon());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's icon and
     * expects a resource id as a parameter.
     */
    public final void testSetIconWithResourceIdParameter() {
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setIcon(getContext(), android.R.drawable.ic_delete);
        assertNotNull(preferenceHeader.getIcon());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's fragment.
     */
    public final void testSetFragment() {
        String fragment = "com.android.Fragment";
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setFragment(fragment);
        assertEquals(fragment, preferenceHeader.getFragment());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's intent.
     */
    public final void testSetIntent() {
        Intent intent = new Intent();
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setIntent(intent);
        assertEquals(intent, preferenceHeader.getIntent());
    }

    /**
     * Tests the functionality of the method, which allows to set the preference header's extras.
     */
    public final void testSetExtras() {
        Bundle extras = new Bundle();
        PreferenceHeader preferenceHeader = new PreferenceHeader("foo");
        preferenceHeader.setExtras(extras);
        assertEquals(extras, preferenceHeader.getExtras());
    }

    /**
     * Tests the functionality of the describeContents-method.
     */
    public final void testDescribeContents() {
        assertEquals(0, new PreferenceHeader("foo").describeContents());
    }

    /**
     * Tests the functionality of the writeToParcel-method.
     */
    public final void testWriteToParcel() {
        CharSequence title = "title";
        CharSequence summary = "summary";
        CharSequence breadCrumbTitle = "breadCrumbTitle";
        CharSequence breadCrumbShortTitle = "breadCrumbShortTitle";
        Drawable icon = ContextCompat.getDrawable(getContext(), android.R.drawable.ic_delete);
        String fragment = "com.android.Fragment";
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        PreferenceHeader preferenceHeader = new PreferenceHeader(title);
        preferenceHeader.setSummary(summary);
        preferenceHeader.setBreadCrumbTitle(breadCrumbTitle);
        preferenceHeader.setBreadCrumbShortTitle(breadCrumbShortTitle);
        preferenceHeader.setIcon(icon);
        preferenceHeader.setFragment(fragment);
        preferenceHeader.setIntent(intent);
        preferenceHeader.setExtras(extras);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key", preferenceHeader);
        PreferenceHeader restoredPreferenceHeader = bundle.getParcelable("key");
        assertEquals(title, restoredPreferenceHeader.getTitle());
        assertEquals(summary, restoredPreferenceHeader.getSummary());
        assertEquals(breadCrumbTitle, restoredPreferenceHeader.getBreadCrumbTitle());
        assertEquals(breadCrumbShortTitle, restoredPreferenceHeader.getBreadCrumbShortTitle());
        assertNotNull(restoredPreferenceHeader.getIcon());
        assertEquals(fragment, restoredPreferenceHeader.getFragment());
        assertEquals(intent, restoredPreferenceHeader.getIntent());
        assertEquals(extras, restoredPreferenceHeader.getExtras());
    }

    /**
     * Tests the createFromParcel-method of the creator, which allows to create instances from a
     * {@link Parcel}.
     */
    public final void testCreatorCreateFromParcel() {
        CharSequence title = "title";
        CharSequence summary = "summary";
        CharSequence breadCrumbTitle = "breadCrumbTitle";
        CharSequence breadCrumbShortTitle = "breadCrumbShortTitle";
        Drawable icon = ContextCompat.getDrawable(getContext(), android.R.drawable.ic_delete);
        String fragment = "com.android.Fragment";
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        PreferenceHeader preferenceHeader = new PreferenceHeader(title);
        preferenceHeader.setSummary(summary);
        preferenceHeader.setBreadCrumbTitle(breadCrumbTitle);
        preferenceHeader.setBreadCrumbShortTitle(breadCrumbShortTitle);
        preferenceHeader.setIcon(icon);
        preferenceHeader.setFragment(fragment);
        preferenceHeader.setIntent(intent);
        preferenceHeader.setExtras(extras);
        Parcel parcel = Parcel.obtain();
        preferenceHeader.writeToParcel(parcel, 1);
        parcel.setDataPosition(0);
        PreferenceHeader createdPreferenceHeader =
                PreferenceHeader.CREATOR.createFromParcel(parcel);
        assertEquals(title, createdPreferenceHeader.getTitle());
        assertEquals(summary, createdPreferenceHeader.getSummary());
        assertEquals(breadCrumbTitle, createdPreferenceHeader.getBreadCrumbTitle());
        assertEquals(breadCrumbShortTitle, createdPreferenceHeader.getBreadCrumbShortTitle());
        assertNotNull(createdPreferenceHeader.getIcon());
        assertEquals(fragment, createdPreferenceHeader.getFragment());
        assertNotNull(createdPreferenceHeader.getIntent());
        assertNotNull(createdPreferenceHeader.getExtras());
        parcel.recycle();
    }

    /**
     * Tests the newArray-method of the creator, which allows to create instances from a {@link
     * Parcel}.
     */
    public final void testCreatorNewArray() {
        int size = 1;
        PreferenceHeader[] array = PreferenceHeader.CREATOR.newArray(size);
        assertEquals(size, array.length);
    }

}