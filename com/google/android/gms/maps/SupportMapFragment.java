package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private final zzb zzaGH;

    class zza implements MapLifecycleDelegate {
        private final IMapFragmentDelegate zzaFW;
        private final Fragment zzadh;

        class 1 extends com.google.android.gms.maps.internal.zzl.zza {
            final OnMapReadyCallback zzaFX;
            final zza zzaGI;

            1(zza com_google_android_gms_maps_SupportMapFragment_zza, OnMapReadyCallback onMapReadyCallback) {
                this.zzaGI = com_google_android_gms_maps_SupportMapFragment_zza;
                this.zzaFX = onMapReadyCallback;
            }

            public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
                this.zzaFX.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zzaFW = (IMapFragmentDelegate) zzx.zzv(iMapFragmentDelegate);
            this.zzadh = (Fragment) zzx.zzv(fragment);
        }

        public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.zzaFW.getMapAsync(new 1(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle bundle) {
            if (bundle == null) {
                try {
                    bundle = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzadh.getArguments();
            if (arguments != null) {
                try {
                    if (arguments.containsKey("MapOptions")) {
                        com.google.android.gms.maps.internal.zzx.zza(bundle, "MapOptions", arguments.getParcelable("MapOptions"));
                    }
                } catch (RemoteException e2) {
                    throw e2;
                } catch (RemoteException e22) {
                    throw e22;
                }
            }
            this.zzaFW.onCreate(bundle);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                return (View) zze.zzp(this.zzaFW.onCreateView(zze.zzx(layoutInflater), zze.zzx(viewGroup), bundle));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaFW.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaFW.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            try {
                this.zzaFW.onInflate(zze.zzx(activity), (GoogleMapOptions) bundle.getParcelable("MapOptions"), bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaFW.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaFW.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaFW.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle bundle) {
            try {
                this.zzaFW.onSaveInstanceState(bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    class zzb extends com.google.android.gms.dynamic.zza {
        private Activity mActivity;
        protected zzf zzaFZ;
        private final List zzaGa;
        private final Fragment zzadh;

        zzb(Fragment fragment) {
            this.zzaGa = new ArrayList();
            this.zzadh = fragment;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
            zzwP();
        }

        static void zza(zzb com_google_android_gms_maps_SupportMapFragment_zzb, Activity activity) {
            com_google_android_gms_maps_SupportMapFragment_zzb.setActivity(activity);
        }

        protected void zza(zzf com_google_android_gms_dynamic_zzf) {
            this.zzaFZ = com_google_android_gms_dynamic_zzf;
            zzwP();
        }

        public void zzwP() {
            int i = MapView.a;
            try {
                if (this.mActivity != null && this.zzaFZ != null) {
                    if (zzrn() == null) {
                        try {
                            MapsInitializer.initialize(this.mActivity);
                            IMapFragmentDelegate zzt = zzy.zzaF(this.mActivity).zzt(zze.zzx(this.mActivity));
                            if (zzt != null) {
                                this.zzaFZ.zza(new zza(this.zzadh, zzt));
                                for (OnMapReadyCallback mapAsync : this.zzaGa) {
                                    ((zza) zzrn()).getMapAsync(mapAsync);
                                    if (i != 0) {
                                        break;
                                    }
                                }
                                this.zzaGa.clear();
                            }
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        } catch (GooglePlayServicesNotAvailableException e2) {
                        }
                    }
                }
            } catch (RemoteException e3) {
                throw e3;
            } catch (RemoteException e32) {
                throw e32;
            }
        }
    }

    public SupportMapFragment() {
        this.zzaGH = new zzb(this);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        zzb.zza(this.zzaGH, activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzaGH.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.zzaGH.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.zzaGH.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaGH.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        zzb.zza(this.zzaGH, activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", createFromAttributes);
        this.zzaGH.onInflate(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.zzaGH.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaGH.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaGH.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.zzaGH.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
