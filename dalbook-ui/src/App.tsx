import React, { lazy } from 'react';

const LayoutPage = lazy(() => import('@components/templates/Layout/LayoutDefault'));

const App = [
    {
        path: '/*',
        element: <LayoutPage />
    },
];

export default App;
