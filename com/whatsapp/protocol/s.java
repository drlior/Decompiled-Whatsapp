package com.whatsapp.protocol;

class s extends a {
    final b5 a;
    final Runnable b;
    final by c;

    public void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public void a(cw cwVar, String str) {
        if (this.b != null) {
            this.b.run();
        }
    }

    s(by byVar, Runnable runnable, b5 b5Var) {
        this.c = byVar;
        this.b = runnable;
        this.a = b5Var;
    }
}
